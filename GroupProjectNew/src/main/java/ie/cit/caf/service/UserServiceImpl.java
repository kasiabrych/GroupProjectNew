package ie.cit.caf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ie.cit.caf.entity.User;
import ie.cit.caf.jparepo.UserJpaRepo;

public class UserServiceImpl {

	@Autowired
	UserJpaRepo repo;

	public UserServiceImpl(UserJpaRepo repo) {
		super();
		this.repo = repo;
	}
	public UserServiceImpl() {
		super();
	}
	public void saveUser(User user) {
		repo.save(user);
	}
}
