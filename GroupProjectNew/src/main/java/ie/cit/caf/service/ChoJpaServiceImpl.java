package ie.cit.caf.service;

import ie.cit.caf.entity.CHObject;
import ie.cit.caf.jparepo.ChoJpaRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Implementation service class for CHObject entity. Refers to jpa methods from ChoJpaRepo (autowired)
 * @author R00048777
 *
 */
@Service
public class ChoJpaServiceImpl implements ChoJpaService{
	
	@Autowired
	ChoJpaRepo repo;

	public ChoJpaServiceImpl(ChoJpaRepo repo) {
		super();
		this.repo = repo;
	}
	public ChoJpaServiceImpl() {
		super();
	}


	@Override
	public List<CHObject> findByMediumContains(String mediumName) {
		// TODO Auto-generated method stub
		return repo.findByMediumContains(mediumName);
	}

	@Override
	public List<CHObject> findByTitleContains(String word) {
		// TODO Auto-generated method stub
		return repo.findByTitleContains(word);
	}

	@Override
	public List<CHObject> findByDescriptionContains(String word) {
		// TODO Auto-generated method stub
		return repo.findByDescriptionContains(word);
	}

	@Override
	public List<CHObject> findByCreditlineContains(String word) {
		// TODO Auto-generated method stub
		return repo.findByCreditlineContains(word);
	}
	@Override
	public CHObject findOne(int id) {
		// TODO Auto-generated method stub
		return repo.findOne(id);
	}
	@Override
	public List<CHObject> findCHObjectsByParticipationsParticipationId(
			int partId) {
		// TODO Auto-generated method stub
		return repo.findCHObjectsByParticipationsParticipationId(partId);
	}
	
	

}
