package ie.cit.caf.service;

import ie.cit.caf.entity.Participant;

public interface ParticipantJpaService {
	
	Iterable <Participant> findByPersonNameLike(String name); 

}
