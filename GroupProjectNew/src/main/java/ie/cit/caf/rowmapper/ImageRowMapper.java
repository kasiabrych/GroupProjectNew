package ie.cit.caf.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.caf.domain.Image;

public class ImageRowMapper implements RowMapper<Image>{
	
@Override
	public Image mapRow(ResultSet rs, int index) throws SQLException {
		Image image = new Image();
		
		image.setImage_no(rs.getInt("image_no"));
		image.setUrl(rs.getString("url"));
		image.setWidth(rs.getString("width"));
		image.setHeight(rs.getString("height")); 
		image.setImage_id(rs.getString("image_id"));
		
		return image;
	}
}