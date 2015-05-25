package ie.cit.caf.service;

import ie.cit.caf.domain.CHObject;

import java.util.List;

public interface CHObjectService {

public CHObject get (int id); 
	
	public void save (CHObject chobject); 
	
	public void remove (CHObject chobject); 
	
	public List<CHObject> findAll(); 
}
