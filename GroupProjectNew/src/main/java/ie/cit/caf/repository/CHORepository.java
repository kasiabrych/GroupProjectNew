package ie.cit.caf.repository;

import java.util.List;

import ie.cit.caf.domain.CHObject;

public interface CHORepository {

	public CHObject get (int id); 
	
	public void save (CHObject chobject); 
	
	public void remove (CHObject chobject); 
	
	public List<CHObject> findAll(); 
	
}
