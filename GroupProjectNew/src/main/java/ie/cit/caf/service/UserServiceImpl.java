package ie.cit.caf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ie.cit.caf.entity.User;
import ie.cit.caf.jparepo.UserJpaRepo;
/**
 * Implementation of service layer for User entity. 
 * UserJpaRepo autowired. 
 * Code commented out due to autowiring conflicts with the UserDaoImpl class for the moment
 * @author R00048777
 *
 */
@Service
public class UserServiceImpl //implements UserService
{

//	@Autowired
//	UserJpaRepo repo;
//
//	public UserServiceImpl(UserJpaRepo repo) {
//		super();
//		this.repo = repo;
//	}
//	public UserServiceImpl() {
//		super();
//	}
//	@Override
//	public void save(User user) {
//		repo.save(user);
//	}
//	@Override
//	public User findByUsername(String username) {
//		return repo.findByUsername(username); 
//	}
//	@Override
//	public List<User> findAll() {
//		return repo.findAll();
//	}
//	@Override
//	public void delete(User user) {
//		repo.delete(user);
//	}
//	@Override
//	public User findOne(int id) {
//		return repo.findOne(id); 
//	}
}
