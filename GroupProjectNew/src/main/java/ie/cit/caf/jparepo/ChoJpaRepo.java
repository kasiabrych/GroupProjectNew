package ie.cit.caf.jparepo;

import java.util.List;

import ie.cit.caf.entity.CHObject;
import ie.cit.caf.entity.Participation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoJpaRepo extends CrudRepository <CHObject, Integer>{
	
	public List<CHObject> findByMediumContains(String mediumName);
	
	//this method is not needed, has the same effect as findOne(int id) from CrudRepository
	public List<Participation> findParticipationsById(int id); 

}
