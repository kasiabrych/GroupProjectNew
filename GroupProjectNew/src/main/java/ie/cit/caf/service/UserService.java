package ie.cit.caf.service;

import ie.cit.caf.entity.User;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 * Service interface for User entity
 * @author R00048777
 *
 */
@Service
public interface UserService {

public User findByUsername(String username); 
	
	public List <User> findAll();

	void save(User user); 
	
	void delete(User user); 
	
	public User findOne(int id); 
	
}
