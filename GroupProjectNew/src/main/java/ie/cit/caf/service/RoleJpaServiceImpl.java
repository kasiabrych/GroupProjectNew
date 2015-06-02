package ie.cit.caf.service;

import ie.cit.caf.jparepo.RoleJpaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
