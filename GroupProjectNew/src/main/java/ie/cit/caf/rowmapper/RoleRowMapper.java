package ie.cit.caf.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.caf.domain.Role;

public class RoleRowMapper implements RowMapper<Role>{
	
@Override
	public Role mapRow(ResultSet rs, int index) throws SQLException {
		Role role = new Role();
		
		role.setRole_no(rs.getInt("role_no"));
		role.setRole_id(rs.getString("role_id"));
		role.setRole_name(rs.getString("role_name"));
		role.setRole_display_name(rs.getString("role_display_name")); 
		role.setRole_url(rs.getString("role_url"));
		
		return role;
	}
}

