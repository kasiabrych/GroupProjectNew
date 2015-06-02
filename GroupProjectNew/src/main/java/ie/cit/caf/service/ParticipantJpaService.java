package ie.cit.caf.service;

import ie.cit.caf.entity.Participant;
/**
 * Service interface for Participant entity
 * @author R00048777
 *
 */
public interface ParticipantJpaService {
	
	Iterable <Participant> findByPersonNameLike(String name); 

}
