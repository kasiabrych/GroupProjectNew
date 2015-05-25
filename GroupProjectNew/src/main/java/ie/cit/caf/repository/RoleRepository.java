package ie.cit.caf.repository;

import ie.cit.caf.domain.Role;

import java.util.List;

public interface RoleRepository {
	
	public Role get (int id); 
	
	public void save (Role role); 
	
	public void remove (Role role); 
	
	public List<Role> findAll(); 
	
	public Role checkIfExist(int id); 

}
