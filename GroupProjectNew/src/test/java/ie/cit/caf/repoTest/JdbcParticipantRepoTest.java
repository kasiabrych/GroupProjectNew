package ie.cit.caf.repoTest;

import static org.junit.Assert.*;

import java.util.List;

import ie.cit.caf.config.DefaultConfig;
import ie.cit.caf.domain.Image;
import ie.cit.caf.domain.Participant;
import ie.cit.caf.domain.Role;
import ie.cit.caf.repository.JdbcImageRepository;
import ie.cit.caf.repository.JdbcParticipantRepository;

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
public class JdbcParticipantRepoTest {
	
	@Autowired
	JdbcParticipantRepository repo;
	
	@Test
	public void get() {
		Participant p = repo.get(1);
		assertEquals("Design Group Inc.", p.getPerson_name());
	}
	
	@Test
	public void findAll() {
		List<Participant> partList = repo.findAll();
		assertEquals(113, partList.size());
	}
	@Test
	@Transactional
	public void remove() {
		Participant p = repo.get(1);
		repo.remove(p);
		List<Participant> partList = repo.findAll();
		assertEquals(112, partList.size());
	}
	@Test
	@Transactional
	public void save() {
		Participant p = new Participant(); 
		p.setPerson_id("75");
		p.setPerson_name("Pet the Vet");
		p.setPerson_date("Yesterday");
		p.setPerson_url("person_url");
		repo.save(p);
		List<Participant> pList = repo.findAll();
		assertEquals(114, pList.size());
	}
}