package ie.cit.caf.jparepo;

import ie.cit.caf.entity.Participant;
import ie.cit.caf.entity.Participation;
import ie.cit.caf.entity.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository interface for Participation. 
 * Implements CrudRepository and contains some additional method signatures 
 * for finding participations, participant and roles. 
 * @author R00048777
 *
 */
@Repository
public interface ParticipationJpaRepo extends CrudRepository <Participation, Integer>{
	
	public Role findRoleByParticipant(Participant part);
	
	public Iterable <Participation> findParticipationByParticipant(Participant part);
	
	public Iterable <Participation> findParticipationByParticipantParticipantId(int id);
	
	public Iterable<Role> findRoleByParticipantParticipantId(int id);
	
	public Iterable<Participation> findParticipationByParticipantPersonNameContains(String name);

}
