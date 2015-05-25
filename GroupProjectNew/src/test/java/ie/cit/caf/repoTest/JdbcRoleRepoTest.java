package ie.cit.caf.repoTest;

import static org.junit.Assert.*;

import java.util.List;

import ie.cit.caf.config.DefaultConfig;
import ie.cit.caf.domain.Role;
import ie.cit.caf.repository.JdbcRoleRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DefaultConfig.class)
@TransactionConfiguration(defaultRollback=true) 
public class JdbcRoleRepoTest {
	
	@Autowired
	JdbcRoleRepository repo;
	
	@Test
	public void get() {
		Role r = repo.get(1);
		assertEquals("Manufacturer", r.getRole_name());
	}
	
	@Test
	public void findAll() {
		List<Role> roleList = repo.findAll();
		assertEquals(113, roleList.size());
	}
	@Test
	@Transactional
	public void remove() {
		Role r = repo.get(1);
		repo.remove(r);
		List<Role> roleList = repo.findAll();
		assertEquals(112, roleList.size());
	}
	@Test
	@Transactional
	public void save() {
		Role r = new Role(); 
		r.setRole_id("75");
		r.setRole_name("Painter");
		r.setRole_display_name("Painted by");
		r.setRole_url("role_url");
		repo.save(r);
		List<Role> roleList = repo.findAll();
		assertEquals(114, roleList.size());
	}
}