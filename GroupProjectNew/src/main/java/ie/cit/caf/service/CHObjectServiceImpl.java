package ie.cit.caf.service;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.repository.CHORepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CHObjectServiceImpl implements CHObjectService{
	
	CHORepository choRepository;
	
	@Autowired
	public CHObjectServiceImpl(CHORepository choRepository) {
	this.choRepository = choRepository;
	}


	@Override
	public CHObject get(int id) {
		return choRepository.get(id); 
	}

	@Override
	public void save(CHObject chobject) {
		choRepository.save(chobject);
		
	}

	@Override
	public void remove(CHObject chobject) {
		choRepository.remove(chobject);
		
	}

	@Override
	public List<CHObject> findAll() {
		return choRepository.findAll();
	}

}
