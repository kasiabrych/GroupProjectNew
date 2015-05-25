package ie.cit.caf.repoTest;

import static org.junit.Assert.*;

import java.util.List;

import ie.cit.caf.config.DefaultConfig;
import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Role;
import ie.cit.caf.repository.CHORepository;
import ie.cit.caf.repository.JdbcChoRepository;
import ie.cit.caf.GroupProjectApplication;

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
public class JdbcChoRepositoryTest {
	
	@Autowired
	JdbcChoRepository jdbcChoRepository;
	
	@Test
	public void get() {
		CHObject cho = jdbcChoRepository.get(68268203);
		assertEquals("Folder, Trees, 1960", cho.getTitle());
	}
	
	@Test
	public void findAll() {
		List<CHObject> choList = jdbcChoRepository.findAll();
		assertEquals(35, choList.size());
	}
	@Test
	@Transactional
	public void remove() {
		CHObject cho = jdbcChoRepository.get(68268203);
		jdbcChoRepository.remove(cho);
		List<CHObject> choList = jdbcChoRepository.findAll();
		assertEquals(34, choList.size());
	}
	@Test
	@Transactional
	public void save() {
		CHObject cho = new CHObject(); 
		cho.setId(1);
		cho.setTitle("Painter");
		cho.setCreditline("no credit");
		cho.setDate("tomorrow");
		cho.setDescription("blank");
		cho.setGallery_text(null);
		cho.setMedium("medium");
		jdbcChoRepository.save(cho);
		List<CHObject> choList = jdbcChoRepository.findAll();
		assertEquals(36, choList.size());
	}
}