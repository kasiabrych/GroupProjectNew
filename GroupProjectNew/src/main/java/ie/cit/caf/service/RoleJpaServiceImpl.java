package ie.cit.caf.service;

import ie.cit.caf.jparepo.RoleJpaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Service interface for Role entity implemented here. 
 * RoleJpaRepo autowired. At the moment no additional methods. 
 * @author R00048777
 *
 */
@Service
public class RoleJpaServiceImpl implements RoleJpaService{
	
	@Autowired
	RoleJpaRepo repo;

	public RoleJpaServiceImpl(RoleJpaRepo repo) {
		super();
		this.repo = repo;
	}
	public RoleJpaServiceImpl() {
		super();
	}

}
