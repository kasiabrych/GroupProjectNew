package ie.cit.caf.service;

import ie.cit.caf.entity.Participant;
import ie.cit.caf.entity.Participation;
import ie.cit.caf.entity.Role;
/**
 * Service interface for Participation. 
 * @author R00048777
 *
 */
public interface ParticipationJpaService {
	
	public Role findRoleByParticipant(Participant part);
	
	public Iterable <Participation> findParticipationByParticipant(Participant part);
	
	public Iterable <Participation> findParticipationByParticipantParticipantId(int id);
	
	public Iterable<Role> findRoleByParticipantParticipantId(int id);

}
