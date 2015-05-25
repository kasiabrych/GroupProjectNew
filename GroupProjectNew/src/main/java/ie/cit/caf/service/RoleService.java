package ie.cit.caf.service;

import ie.cit.caf.domain.Role;

import java.util.List;

public interface RoleService {
	
	public Role get (int id); 
	
	public void save (Role role); 
	
	public void remove (Role role); 
	
	public List<Role> findAll(); 

}
