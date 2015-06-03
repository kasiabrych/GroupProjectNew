package ie.cit.caf.jpaRepoTest;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import ie.cit.caf.config.DefaultConfig;
import ie.cit.caf.domain.CHObject;
import ie.cit.caf.jparepo.ChoJpaRepo;
import ie.cit.caf.repository.JdbcChoRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DefaultConfig.class)
@TransactionConfiguration(defaultRollback=true) 
public class JpaChoRepoTest {

	@Autowired
	ChoJpaRepo repo;
	
	@Test
	public void findOne() {
		ie.cit.caf.entity.CHObject cho = repo.findOne(68268203);
		assertEquals("Folder, Trees, 1960", cho.getTitle());
	}
	
	@Test
	public void findAll() {
		Iterable<ie.cit.caf.entity.CHObject> choList = repo.findAll();
		assertEquals(35, ((Collection<ie.cit.caf.entity.CHObject>) choList).size());
	}
	@Test
	@Transactional
	public void remove() {
		ie.cit.caf.entity.CHObject cho = repo.findOne(68268203);
		repo.delete(cho);
		Iterable<ie.cit.caf.entity.CHObject> choList = repo.findAll();
		assertEquals(34, ((Collection<ie.cit.caf.entity.CHObject>) choList).size());
	}
	@Test
	@Transactional
	public void save() {
		ie.cit.caf.entity.CHObject cho = new ie.cit.caf.entity.CHObject(); 
		cho.setId(1);
		cho.setTitle("Painter");
		cho.setCreditline("no credit");
		cho.setDate("tomorrow");
		cho.setDescription("blank");
		cho.setGallery_text(null);
		cho.setMedium("medium");
		repo.save(cho);
		Iterable<ie.cit.caf.entity.CHObject> choList = repo.findAll();
		assertEquals(36, ((Collection<ie.cit.caf.entity.CHObject>) choList).size());
	}

}
