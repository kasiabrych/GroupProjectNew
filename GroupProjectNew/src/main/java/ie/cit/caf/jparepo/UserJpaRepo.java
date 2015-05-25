package ie.cit.caf.jparepo;

import java.util.List;

import ie.cit.caf.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepo extends CrudRepository<User, Integer> {
	
	public List <User> findByUserName(String userName); 
	
	public List <User> findAll(); 
	

}
