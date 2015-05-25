package ie.cit.caf.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.caf.domain.Participant;

public class ParticipantRowMapper implements RowMapper<Participant>{
	
@Override
	public Participant mapRow(ResultSet rs, int index) throws SQLException {
		Participant part = new Participant();
		
		part.setParticipant_id(rs.getInt("participant_id"));
		part.setPerson_id(rs.getString("person_id"));
		part.setPerson_name(rs.getString("person_name"));
		part.setPerson_date(rs.getString("person_date")); 
		part.setPerson_url(rs.getString("person_url"));
		
		return part;
	}
}

