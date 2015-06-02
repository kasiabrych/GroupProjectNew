package ie.cit.caf.jparepo;

import ie.cit.caf.entity.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Role. 
 * @author R00048777
 *
 */
@Repository
public interface RoleJpaRepo extends CrudRepository<Role, Integer>{

}
