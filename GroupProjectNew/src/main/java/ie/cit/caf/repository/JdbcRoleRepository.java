package ie.cit.caf.repository;

import ie.cit.caf.domain.Role;
import ie.cit.caf.rowmapper.RoleRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRoleRepository implements RoleRepository{
	
private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JdbcRoleRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
		
	}


	@Override
	public Role get(int id) {
		String sql = "SELECT * FROM roles WHERE role_no = ?";
		Role role = jdbcTemplate.queryForObject(sql, new Object[] { id }, 
				new RoleRowMapper());
		return role; 	
	}

	@Override
	public void save(Role role) {
		//if (role.getRole_no() ==0){
//		String sql = "INSERT INTO roles (role_id, role_name, role_display_name, role_url) "
//				+ "VALUES (?, ?, ?, ?)"; 
//		jdbcTemplate.update(sql, 
//				new Object [] {role.getRole_id(), role.getRole_name(), 
//					role.getRole_display_name(), role.getRole_url()} ); 
		
		SimpleJdbcInsert insertR = new SimpleJdbcInsert(jdbcTemplate).withTableName("roles")
				.usingGeneratedKeyColumns("role_no");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("role_id", role.getRole_id());
		parameters.put("role_name", role.getRole_name());
		parameters.put("role_display_name", role.getRole_display_name()); 
		parameters.put("role_url", role.getRole_url()); 
		Number newId = insertR.executeAndReturnKey(parameters);
		role.setRole_no(newId.intValue());
		}
		
	//}

	@Override
	public void remove(Role role) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM roles WHERE role_no = ?";
		jdbcTemplate.update(sql, new Object[] { role.getRole_no() } );
	}

	@Override
	public List<Role> findAll() {
			String sql = "SELECT * FROM roles";
			return jdbcTemplate.query(sql, new RoleRowMapper());
	}
	
	public Role checkIfExist(int id) {
		try{
			String sql = "SELECT * FROM roles WHERE role_id = ?";
			Role role = jdbcTemplate.queryForObject(sql, new Object[] { id }, 
					new RoleRowMapper());
			return role; 	
		} catch (EmptyResultDataAccessException e) {
					return null;
		}
	}

}
