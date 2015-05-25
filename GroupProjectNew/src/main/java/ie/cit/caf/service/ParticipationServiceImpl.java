package ie.cit.caf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Participant;
import ie.cit.caf.domain.Role;
import ie.cit.caf.repository.ParticipationRepository;

@Service
public class ParticipationServiceImpl implements ParticipationService{

	ParticipationRepository pRep;

	@Autowired
	public ParticipationServiceImpl(ParticipationRepository pRep) {
		this.pRep = pRep; ;
	}


	@Override
	public void saveParticipation(CHObject cho, Participant p, Role r) {
		pRep.saveParticipation(cho, p, r);
	}

}
