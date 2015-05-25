package ie.cit.caf.repository;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Image;
import ie.cit.caf.rowmapper.ImageRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcImageRepository implements ImageRepository{
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JdbcImageRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
		
	}

	@Override
	public Image get(int id) {
		String sql = "SELECT * FROM images WHERE image_no = ?";
		Image image = jdbcTemplate.queryForObject(sql, new Object[] { id }, 
				new ImageRowMapper());
		return image; 	
	}

	@Override
	public void save(Image image) {
//			String sql = "INSERT INTO images (url, width, height, image_id) "
//					+ "VALUES (?, ?, ?, ?)"; 
//			jdbcTemplate.update(sql, 
//					new Object [] {image.getUrl(), image.getWidth(), 
//						image.getHeight(), image.getImage_id()} ); 
			SimpleJdbcInsert insertI = new SimpleJdbcInsert(jdbcTemplate).withTableName("images")
					.usingGeneratedKeyColumns("image_no");
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("url", image.getUrl());
			parameters.put("width", image.getWidth());
			parameters.put("height", image.getHeight()); 
			parameters.put("image_id", image.getImage_id()); 
			Number newId = insertI.executeAndReturnKey(parameters);
			image.setImage_no(newId.intValue());
			}

	public void linkImageToCho(Image image, CHObject cho){
		String sql = "INSERT INTO cho_images (cho_id, image_no) "
					+ "VALUES (?, ?)"; 
			jdbcTemplate.update(sql, 
					new Object [] {cho.getId(), image.getImage_no()}); 
			}
		
	
	@Override
	public void remove(Image image) {
		String sql = "DELETE FROM images WHERE image_no = ?";
		jdbcTemplate.update(sql, new Object[] { image.getImage_no() } );
	}

	@Override
	public List<Image> findAll() {
		String sql = "SELECT * FROM images";
		return jdbcTemplate.query(sql, new ImageRowMapper());
		
	}

}
