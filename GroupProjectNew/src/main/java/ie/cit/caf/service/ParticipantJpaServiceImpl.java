package ie.cit.caf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.caf.entity.Participant;
import ie.cit.caf.jparepo.ParticipantJpaRepo;
/**
 * Service for Participant entity implemented here
 * @author R00048777
 *
 */
@Service
public class ParticipantJpaServiceImpl implements ParticipantJpaService{
	
	@Autowired
	ParticipantJpaRepo repo;

	public ParticipantJpaServiceImpl(ParticipantJpaRepo repo) {
		super();
		this.repo = repo;
	}
	public ParticipantJpaServiceImpl() {
		super();
	}

	@Override
	public Iterable<Participant> findByPersonNameLike(String name) {
		// TODO Auto-generated method stub
		return repo.findByPersonNameLike(name);
	}

}
