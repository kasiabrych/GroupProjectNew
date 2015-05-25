package ie.cit.caf.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import ie.cit.caf.domain.B;
import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.D;
import ie.cit.caf.domain.Images;
import ie.cit.caf.domain.N;
import ie.cit.caf.domain.Sq;
import ie.cit.caf.domain.Z;

@Repository
public class JdbcImagesRepo implements ImagesRepository{
private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JdbcImagesRepo(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
		
	}

	@Override
	public void saveImagesWithCHOId(Images images, CHObject cho){
		
		SimpleJdbcInsert insertB = new SimpleJdbcInsert(jdbcTemplate).withTableName("images")
				.usingGeneratedKeyColumns("image_no");
		Map<String, Object> paramsB = new HashMap<String, Object>();
		B b = images.getB(); 
		paramsB.put("image_resolution", "B"); 
		paramsB.put("url", b.getUrl());
		paramsB.put("width", b.getWidth());
		paramsB.put("height", b.getHeight()); 
		paramsB.put("image_id", b.getImage_id()); 
		paramsB.put("cho_id", cho.getId()); 
		paramsB.put("is_primary", b.getIs_primary()); 
		Number newId = insertB.executeAndReturnKey(paramsB);
		b.setImage_no(newId.intValue());
		
		SimpleJdbcInsert insertD = new SimpleJdbcInsert(jdbcTemplate).withTableName("images")
				.usingGeneratedKeyColumns("image_no");
		Map<String, Object> paramsD = new HashMap<String, Object>();
		D d = images.getD(); 
		paramsD.put("image_resolution", "D"); 
		paramsD.put("url", d.getUrl());
		paramsD.put("width", d.getWidth());
		paramsD.put("height", d.getHeight()); 
		paramsD.put("image_id", d.getImage_id()); 
		paramsD.put("cho_id", cho.getId());
		paramsD.put("is_primary", d.getIs_primary()); 
		Number newD = insertD.executeAndReturnKey(paramsD);
		d.setImage_no(newD.intValue());
		
		SimpleJdbcInsert insertN = new SimpleJdbcInsert(jdbcTemplate).withTableName("images")
				.usingGeneratedKeyColumns("image_no");
		Map<String, Object> paramsN = new HashMap<String, Object>();
		N n = images.getN(); 
		paramsN.put("image_resolution", "N"); 
		paramsN.put("url", n.getUrl());
		paramsN.put("width", n.getWidth());
		paramsN.put("height", n.getHeight()); 
		paramsN.put("image_id", n.getImage_id()); 
		paramsN.put("cho_id", cho.getId());
		paramsN.put("is_primary", n.getIs_primary()); 
		Number newN = insertN.executeAndReturnKey(paramsN);
		n.setImage_no(newN.intValue());
		
		SimpleJdbcInsert insertSq = new SimpleJdbcInsert(jdbcTemplate).withTableName("images")
				.usingGeneratedKeyColumns("image_no");
		Map<String, Object> paramsSq = new HashMap<String, Object>();
		Sq sq= images.getSq(); 
		paramsSq.put("image_resolution", "SQ"); 
		paramsSq.put("url", sq.getUrl());
		paramsSq.put("width", sq.getWidth());
		paramsSq.put("height", sq.getHeight()); 
		paramsSq.put("image_id", sq.getImage_id()); 
		paramsSq.put("cho_id", cho.getId());
		paramsSq.put("is_primary", sq.getIs_primary()); 
		Number newSq = insertSq.executeAndReturnKey(paramsSq);
		sq.setImage_no(newSq.intValue());
		
		SimpleJdbcInsert insertZ = new SimpleJdbcInsert(jdbcTemplate).withTableName("images")
				.usingGeneratedKeyColumns("image_no");
		Map<String, Object> paramsZ = new HashMap<String, Object>();
		Z z = images.getZ(); 
		paramsZ.put("image_resolution", "Z"); 
		paramsZ.put("url", z.getUrl());
		paramsZ.put("width", z.getWidth());
		paramsZ.put("height", z.getHeight()); 
		paramsZ.put("image_id", z.getImage_id()); 
		paramsZ.put("cho_id", cho.getId());
		paramsZ.put("is_primary", z.getIs_primary()); 
		Number newZ = insertZ.executeAndReturnKey(paramsZ);
		z.setImage_no(newZ.intValue());
	}
	@Override
	public void linkImageToCho(Images images, CHObject cho){
		String sqlB = "INSERT INTO cho_images (cho_id, image_no) "
					+ "VALUES (?, ?)"; 
			jdbcTemplate.update(sqlB, 
					new Object [] {cho.getId(), images.getB().getImage_no()}); 
			
			String sqlD = "INSERT INTO cho_images (cho_id, image_no) "
					+ "VALUES (?, ?)"; 
			jdbcTemplate.update(sqlD, 
					new Object [] {cho.getId(), images.getD().getImage_no()}); 
			
			String sqlN = "INSERT INTO cho_images (cho_id, image_no) "
					+ "VALUES (?, ?)"; 
			jdbcTemplate.update(sqlN, 
					new Object [] {cho.getId(), images.getN().getImage_no()}); 
			
			String sqlSq = "INSERT INTO cho_images (cho_id, image_no) "
					+ "VALUES (?, ?)"; 
			jdbcTemplate.update(sqlSq, 
					new Object [] {cho.getId(), images.getSq().getImage_no()}); 
			
			String sqlZ = "INSERT INTO cho_images (cho_id, image_no) "
					+ "VALUES (?, ?)"; 
			jdbcTemplate.update(sqlZ, 
					new Object [] {cho.getId(), images.getZ().getImage_no()}); 
			}


	@Override
	public Images get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Images image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Images> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveImages(Images image) {
		// TODO Auto-generated method stub
		
	}

	}
