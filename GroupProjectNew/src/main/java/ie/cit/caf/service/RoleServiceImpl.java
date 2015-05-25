package ie.cit.caf.service;

import ie.cit.caf.domain.Role;
import ie.cit.caf.repository.RoleRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImpl implements RoleService{

	RoleRepository roleRepo;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepo) {
		this.roleRepo = roleRepo;
	}

	@Override
	public Role get(int id) {
		return roleRepo.get(id);
	}

	@Override
	public void save(Role role) {
		if (roleRepo.checkIfExist(Integer.parseInt(role.getRole_id()))==null)
		roleRepo.save(role);
	}

	@Override
	public void remove(Role role) {
		roleRepo.remove(role);
	}

	@Override
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

}
