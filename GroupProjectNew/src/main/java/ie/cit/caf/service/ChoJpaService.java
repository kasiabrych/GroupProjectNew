package ie.cit.caf.service;

import ie.cit.caf.entity.CHObject;

import java.util.List;
/**
 * Service interface for CHObject entity
 * @author R00048777
 *
 */
public interface ChoJpaService {
	
	public List<CHObject> findByMediumContains(String mediumName);
	
	public List<CHObject> findByTitleContains(String word);
	
	public List<CHObject> findByDescriptionContains(String word);
	
	public List<CHObject> findByCreditlineContains(String word);

	public ie.cit.caf.entity.CHObject findOne(int id);
	

}
