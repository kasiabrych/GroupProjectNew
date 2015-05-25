package ie.cit.caf.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.caf.domain.CHObject;

public class CHORowMapper implements RowMapper<CHObject>{
	
@Override
	public CHObject mapRow(ResultSet rs, int index) throws SQLException {
		CHObject cho = new CHObject();
		
		cho.setId(rs.getInt("id"));
		cho.setTitle(rs.getString("title"));
		cho.setDate(rs.getString("date"));
		cho.setMedium(rs.getString("medium")); 
		cho.setCreditline(rs.getString("creditline"));
		cho.setDescription(rs.getString("description"));
		cho.setGallery_text(rs.getString("gallery_text"));
		
		return cho;
	}
}

