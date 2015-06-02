package ie.cit.caf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.caf.entity.Participant;
import ie.cit.caf.entity.Participation;
import ie.cit.caf.entity.Role;
import ie.cit.caf.jparepo.ParticipationJpaRepo;
/**
 * Implementation of service layer for Participation. 
 * ParticipationJpaRepo autowired. 
 * @author R00048777
 *
 */
@Service
public class ParticipationJpaServiceImpl implements ParticipationJpaService{
	
	@Autowired
	ParticipationJpaRepo repo;

	public ParticipationJpaServiceImpl(ParticipationJpaRepo repo) {
		super();
		this.repo = repo;
	}
	public ParticipationJpaServiceImpl() {
		super();
	}


	@Override
	public Role findRoleByParticipant(Participant part) {
		// TODO Auto-generated method stub
		return repo.findRoleByParticipant(part);
	}

	@Override
	public Iterable<Participation> findParticipationByParticipant(
			Participant part) {
		// TODO Auto-generated method stub
		return repo.findParticipationByParticipant(part);
	}

	@Override
	public Iterable<Participation> findParticipationByParticipantParticipantId(
			int id) {
		// TODO Auto-generated method stub
		return repo.findParticipationByParticipantParticipantId(id);
	}

	@Override
	public Iterable<Role> findRoleByParticipantParticipantId(int id) {
		// TODO Auto-generated method stub
		return repo.findRoleByParticipantParticipantId(id);
	}
	@Override
	public Iterable<Participation> findParticipationByParticipantPersonNameContains(
			String name) {
		// TODO Auto-generated method stub
		return repo.findParticipationByParticipantPersonNameContains(name);
	}

}
