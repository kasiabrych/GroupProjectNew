package ie.cit.caf.repository;


import ie.cit.caf.domain.Participant;
import ie.cit.caf.domain.Role;
import ie.cit.caf.rowmapper.ParticipantRowMapper;
import ie.cit.caf.rowmapper.RoleRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcParticipantRepository implements ParticipantRepository{

	private JdbcTemplate jdbcTemplate; 
	private SimpleJdbcInsert simpleJdbcInsert; 

	@Autowired
	public JdbcParticipantRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;

	}
	@Autowired
	public void setDataSource(DataSource dataSource){
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
		.withTableName("participants") 
		.usingColumns("person_id", "person_name", "person_date", "person_url")
		.usingGeneratedKeyColumns("participant_id"); 
	}

	public void saveInsert(Participant p){
		if (p.getParticipant_id() !=0){
			System.out.println("call to saveInsert: participant exists");
		}else
		{
			Map<String, Object> params = new HashMap<String, Object>(); 
			params.put("person_id", p.getPerson_id());
			params.put("person_name", p.getPerson_name()); 
			params.put("person_date", p.getPerson_date()); 
			params.put("person_url", p.getPerson_url()); 

			Number id = simpleJdbcInsert.executeAndReturnKey(params); 
			p.setParticipant_id(id.intValue());
			System.out.println("Adding new participant "+ p.getParticipant_id()+p.getPerson_name());

		}
	}

	@Override
	public void save(Participant p){
		SimpleJdbcInsert insertP = new SimpleJdbcInsert(jdbcTemplate).withTableName("participants")
				.usingGeneratedKeyColumns("participant_id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("person_id", p.getPerson_id());
		parameters.put("person_name", p.getPerson_name());
		parameters.put("person_date", p.getPerson_date()); 
		parameters.put("person_url", p.getPerson_url()); 
		Number newId = insertP.executeAndReturnKey(parameters);
		p.setParticipant_id(newId.intValue());

	}

	@Override
	public Participant get(int id) {
		try{
		String sql = "SELECT * FROM participants WHERE participant_id = ?";
		Participant part = jdbcTemplate.queryForObject(sql, new Object[] { id }, 
				new ParticipantRowMapper());
		return part; 	
		}catch (EmptyResultDataAccessException e) {
			return null;
}
	}

	@Override
	public void remove(Participant participant) {
		String sql = "DELETE FROM participants WHERE participant_id = ?";
		jdbcTemplate.update(sql, new Object[] { participant.getParticipant_id() } );
	}

	@Override
	public List<Participant> findAll() {
		String sql = "SELECT * FROM participants";
		return jdbcTemplate.query(sql, new ParticipantRowMapper());

	}
	public Participant checkIfExist(int id) {
		try{
			String sql = "SELECT * FROM participants WHERE person_id = ?";
			Participant part = jdbcTemplate.queryForObject(sql, new Object[] { id }, 
					new ParticipantRowMapper());
			return part; 	
		} catch (EmptyResultDataAccessException e) {
					return null;
		}
	}

}
