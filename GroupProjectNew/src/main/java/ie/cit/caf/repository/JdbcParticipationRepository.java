package ie.cit.caf.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Participant;
import ie.cit.caf.domain.Role;
@Repository
public class JdbcParticipationRepository implements ParticipationRepository{
	
	private JdbcTemplate jdbcTemplate; 
		
		@Autowired
		public JdbcParticipationRepository(JdbcTemplate jdbcTemplate){
			this.jdbcTemplate = jdbcTemplate;
			
		}
	@Override
	public void saveParticipation(CHObject cho, Participant p, Role r) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO object_participant_role (object_id, person_id, role_id) "
				+ "VALUES (?, ?, ?)"; 
		jdbcTemplate.update(sql, 
				new Object [] {cho.getId(), p.getPerson_id(), r.getRole_id()}); 
		
	}

	

}
