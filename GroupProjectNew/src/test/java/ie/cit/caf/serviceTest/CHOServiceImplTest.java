package ie.cit.caf.serviceTest;

import java.util.ArrayList;
import java.util.List;
import ie.cit.caf.domain.CHObject;
import ie.cit.caf.repository.CHORepository;
import ie.cit.caf.service.CHObjectService;
import ie.cit.caf.service.CHObjectServiceImpl;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
public class CHOServiceImplTest {
	private CHObjectService choService;
	private CHORepository repoMock;
	
//	@Before
//	public void setup() {
//		repoMock = mock(CHORepository.class);
//		CHObject cho = new CHObject();
//		cho.setId(1);
//		cho.setTitle("Winter");
//		cho.setDate("date1");
//		cho.setMedium("glass"); 
//		cho.setCreditline("some creditLine"); 
//		cho.setGallery_text("some gallery text"); 
//		cho.setParticipations(null);
//		cho.setImages(null);
//		
//		CHObject cho2 = new CHObject();
//		cho2.setId(2);
//		cho2.setTitle("Summer");
//		cho2.setDate("date2");
//		cho2.setMedium("watercolour"); 
//		cho2.setCreditline("second creditLine"); 
//		cho2.setGallery_text("no gallery text"); 
//		cho2.setParticipations(null);
//		cho2.setImages(null);
//		
//		List<CHObject> chobjects = new ArrayList<>();
//		chobjects.add(cho);
//		chobjects.add(cho2);
//		
//		when(repoMock.get(1)).thenReturn(cho);
//		when(repoMock.findAll()).thenReturn(chobjects);
//		choService = new CHObjectServiceImpl(repoMock);
//	}
//	@Test
//	public void get() {
//		assertTrue(choService.get(1).getTitle().equals("Winter"));
//	}
//	@Test
//	public void findAll() {
//		assertTrue(choService.findAll().size() == 2);
//	}
}