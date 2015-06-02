package ie.cit.caf.service;

import ie.cit.caf.entity.UserRole;
import ie.cit.caf.jparepo.UserJpaRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 /**
  * This class in needed for authentication of users based on credentials held in the database. 
  * It implements UserDetailsService interface provided by Spring
  * @author R00048777
  *
  */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
 
	//get user from the database, via Hibernate
	@Autowired
	private UserJpaRepo userJpaRepo;
 /**
  * Method that loads the user and constructs authorities
  */
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
		//retrieving the user
		ie.cit.caf.entity.User user = userJpaRepo.findByUsername(username);
		System.out.println(user);
		//lines commented out, replaced by method using covertRole method from the User class
//		List<GrantedAuthority> authorities = 
//                                      buildUserAuthority(user.getUserRole());
		List<GrantedAuthority> authorities = 
                buildUserAuthority(user.convertRole(user.getRole())); //String converted to an ArrayList
		System.out.println(authorities);
		//return user with authorities
		return buildUserForAuthentication(user, authorities);
 
	}
 
	/**
	 * This method converts ie.cit.caf.entity.User user to 
	 * org.springframework.security.core.userdetails.User
	 * @param user
	 * @param authorities
	 * @return
	 */
	private User buildUserForAuthentication(ie.cit.caf.entity.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), 
			user.isEnabled(), true, true, true, authorities);
	}
 /**
  * Converting arrayList of authorities into a list of type GrantedAuthority
  * @param roleConverted
  * @return
  */
	private List<GrantedAuthority> buildUserAuthority(ArrayList<String> roleConverted) {
		
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (String s : roleConverted) {
			setAuths.add(new SimpleGrantedAuthority(s.toString()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		//return a list of GrantedAuthorities
		return Result;
	}
 
}