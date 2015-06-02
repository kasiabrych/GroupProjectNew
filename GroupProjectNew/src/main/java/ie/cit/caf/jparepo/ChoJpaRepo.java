package ie.cit.caf.jparepo;

import java.util.List;

import ie.cit.caf.entity.CHObject;
import ie.cit.caf.entity.Participation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository interface for CHbject. 
 * Implements CrudRepository and contains some additional method signatures for finding objects. 
 * @author R00048777
 *
 */
@Repository
public interface ChoJpaRepo extends CrudRepository <CHObject, Integer>{
	
	public List<CHObject> findByMediumContains(String mediumName);
	
	public List<CHObject> findByTitleContains(String word);
	
	public List<CHObject> findByDescriptionContains(String word);
	
	public List<CHObject> findByCreditlineContains(String word);
	
	//this method is not needed, has the same effect as findOne(int id) from CrudRepository
	public List<Participation> findParticipationsById(int id); 
	
	public List<CHObject> findCHObjectsByParticipationsParticipationId(int partId); 

}
