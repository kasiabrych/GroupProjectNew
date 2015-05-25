package ie.cit.caf.repository;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Participant;
import ie.cit.caf.domain.Role;

public interface ParticipationRepository {

	public void saveParticipation(CHObject cho, Participant p, Role r); 
}
