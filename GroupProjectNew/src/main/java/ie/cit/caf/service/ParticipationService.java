package ie.cit.caf.service;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Participant;
import ie.cit.caf.domain.Role;

public interface ParticipationService {

	public void saveParticipation(CHObject cho, Participant p, Role r); 
}