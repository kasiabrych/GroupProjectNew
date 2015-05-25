package ie.cit.caf.repoTest;

import static org.junit.Assert.*;

import java.util.List;

import ie.cit.caf.config.DefaultConfig;
import ie.cit.caf.domain.Image;
import ie.cit.caf.domain.Role;
import ie.cit.caf.repository.JdbcImageRepository;
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
public class JdbcImageRepoTest {
	
	@Autowired
	JdbcImageRepository repo;
	
	@Test
	public void get() {
		Image i = repo.get(1);
		assertEquals("90404", i.getImage_id());
	}
	
	@Test
	public void findAll() {
		List<Image> imageList = repo.findAll();
		assertEquals(100, imageList.size());
	}
	@Test
	@Transactional
	public void remove() {
		Image i = repo.get(1);
		repo.remove(i);
		List<Image> imageList = repo.findAll();
		assertEquals(99, imageList.size());
	}
	@Test
	@Transactional
	public void save() {
		Image i = new Image(); 
		i.setImage_id("6785");
		i.setHeight("200");
		i.setWidth("300");
		i.setUrl("image_url");
		i.setIs_primary("1");
		repo.save(i);
		List<Image> iList = repo.findAll();
		assertEquals(101, iList.size());
	}
}