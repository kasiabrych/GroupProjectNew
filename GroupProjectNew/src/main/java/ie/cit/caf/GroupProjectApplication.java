
package ie.cit.caf;
import ie.cit.caf.config.DefaultConfig;
import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Images;
import ie.cit.caf.domain.Participant;
import ie.cit.caf.domain.Participation;
import ie.cit.caf.domain.Role;
import ie.cit.caf.entity.User;
import ie.cit.caf.fileFinder.FileFinder;
import ie.cit.caf.jparepo.ChoJpaRepo;
import ie.cit.caf.jparepo.ImagesJpaRepo;
import ie.cit.caf.jparepo.ParticipantJpaRepo;
import ie.cit.caf.jparepo.ParticipationJpaRepo;
import ie.cit.caf.jparepo.RoleJpaRepo;
import ie.cit.caf.jparepo.UserJpaRepo;
import ie.cit.caf.service.CHObjectService;
import ie.cit.caf.service.ImagesService;
import ie.cit.caf.service.ParticipantService;
import ie.cit.caf.service.ParticipationService;
import ie.cit.caf.service.RoleService;

import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * author Kasia Brych (R00048777)
 * AssignmentApplication class: 
 * deserialises .json files into java objects and stores them in the assignment database
 * 
 */
@SpringBootApplication
@ActiveProfiles ("default")
@Import(DefaultConfig.class)
public class GroupProjectApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {

	//ChoJpaRepo and ImagesJpaRepo to be replaced with service class
	@Autowired
	UserJpaRepo userJpaRepo; 
	@Autowired
	ChoJpaRepo choJpaRepo; 
	@Autowired
	ImagesJpaRepo imagesJpaRepo; 
	@Autowired
	RoleJpaRepo roleJpaRepo; 
	@Autowired
	ParticipantJpaRepo participantJpaRepo; 
	@Autowired
	ParticipationJpaRepo participationJpaRepo; 
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	CHObjectService choService; 
	@Autowired
	RoleService roleService; 
	@Autowired
	ImagesService imagesService; 
	@Autowired 
	ParticipantService participantService; 
	@Autowired 
	ParticipationService participationService; 

	public static void main(String[] args) {
		SpringApplication.run(GroupProjectApplication.class, args);
	}

	//run method converts .json to java objects and stores object in db
	@Override
	public void run(String... args) throws Exception {

		//empty tables
		jdbcTemplate.execute("TRUNCATE TABLE " + "chobjects");
		//jdbcTemplate.execute("TRUNCATE TABLE " + "cho_images");
		jdbcTemplate.execute("TRUNCATE TABLE " + "images");
		jdbcTemplate.execute("TRUNCATE TABLE " + "object_participant_role");
		jdbcTemplate.execute("TRUNCATE TABLE " + "participants");
		jdbcTemplate.execute("TRUNCATE TABLE " + "roles");

		String choFile = args[0]; 
		System.out.printf("Processing file %s...\n", choFile); 

		List <Path> files = FileFinder.getFileList(choFile, "*.json"); 
		for (Path f : files){
			CHObject cho = new ObjectMapper().readValue(f.toFile(), CHObject.class); 
			System.out.println("\n" + cho.toString()); 

			//saving CHObjects using service layer
			choService.save(cho);
			List<Participation> partList = cho.getParticipations(); 
			for (Participation p : partList) {

				//getting the participant
				Participant participant = p.getParticipant(); 
				//using service layer to save participant
				participantService.save(participant);

				Role role = p.getRole(); 
				roleService.save(role); 
				//populating the object_participant_role table using service layer
				participationService.saveParticipation(cho, participant, role); 


			}
			//getting images and saving them (images table now contains the cho_id)
			List<Images> imageList = cho.getImages(); 
			for (Images i : imageList){
				imagesService.saveImagesWithCHOId(i, cho); 
				//imagesRepo.linkImageToCho(i, cho); //unnecessary, as images table now contains cho_id
			}

		}
		//calling jpaExample to try out jpa
		//jpaExample(); 
		//jpaImages(); 
		//jpaPartAndRole(); 
		//jpaParticipation(); 
		//joiningChoAndParticipations(); 
		createUser(); 
	} 

	private void createUser() {
		User user = new User();
		user.setUserName("Brian"); 
		user.setPassword("password");
		user.setNewsletter(true);
		
		userJpaRepo.save(user); 
	
		System.out.println(user);
		
	}

	private void joiningChoAndParticipations() {
		
		Iterable<ie.cit.caf.entity.Participation> list= 
				choJpaRepo.findParticipationsById(68268203); 
		System.out.println("11111111111111111111\nListing participations with ChoJpaRepo: "+list);
		
		ie.cit.caf.entity.CHObject cho=choJpaRepo.findOne(68268203); 
		System.out.println("222222222222222222222\nchoJpaRepo.findOne(int) result: "+cho);
		
	}

	private void jpaParticipation() {
		ie.cit.caf.entity.Participant part = participantJpaRepo.findOne(1); 
		System.out.println("Participant: "+part);
		ie.cit.caf.entity.Role roleName=participationJpaRepo.findRoleByParticipant(part); 
		System.out.println("Role name returned by the participationJpaRepo: "+roleName);
		
		Iterable<ie.cit.caf.entity.Participation> partList = 
				participationJpaRepo.findParticipationByParticipant(part); 
		System.out.println("PartList for part(1): "+partList);
		
		Iterable<ie.cit.caf.entity.Participation> partList2 = 
				participationJpaRepo.findParticipationByParticipantParticipantId(1); 
		System.out.println("PartList for part(1): "+partList2);
		
		Iterable<ie.cit.caf.entity.Role> roleList3 = 
				participationJpaRepo.findRoleByParticipantParticipantId(1); 
		System.out.println("Role for part(1): "+roleList3);
		
		
		
	}

	private void jpaPartAndRole() {
		
		ie.cit.caf.entity.Role role = roleJpaRepo.findOne(4); 
		System.out.println("********Role 4: "+role);
		
		ie.cit.caf.entity.Participant part = participantJpaRepo.findOne(75); 
		System.out.println("££££££££££££££Participant 75: "+part);
		
		ie.cit.caf.entity.Participant part2 = participantJpaRepo.findOne(12); 
		System.out.println("££££££££££££££Participant 12: "+part2);
		
		Iterable<ie.cit.caf.entity.Participant> partList = 
				participantJpaRepo.findByPersonNameLike("Ilonka Karasz"); 
		System.out.println("6666666666666666666666666\n"
				+ "People with name like Ilonka Karasz: "+partList);
		
	}

	public void jpaExample(){

		long count = choJpaRepo.count(); 
		System.out.println("The count is "+ count);

		Iterable<ie.cit.caf.entity.CHObject> list = choJpaRepo.findAll();
		System.out.println(list);
	}
	public void jpaImages(){
		long count = imagesJpaRepo.count(); 
		System.out.println("images count is "+ count);
		
		Iterable<ie.cit.caf.entity.Images> allImages = imagesJpaRepo.findAll(); 
		System.out.println("\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
				+ "All images using crud repository method"+allImages);
		
		List<ie.cit.caf.entity.Images> bImages=imagesJpaRepo.findByImageResolution("B"); 
		System.out.println("\n\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n"
				+ "B Images"+bImages);
		
		System.out.println(imagesJpaRepo.exists(77)); 
		System.out.println(imagesJpaRepo.exists(777)); 
		
		List<ie.cit.caf.entity.Images> idImages = imagesJpaRepo.findByChoId(68268203); 
		System.out.println("\n\n%%%%%%%%%%%%%%%%%%%%%%%\n"
				+ "images for choId 68268203"+idImages);
		
		ie.cit.caf.entity.Images i=imagesJpaRepo.findByChoIdAndImageResolution(68268203, "B"); 
		System.out.println("\n\n**************************\n"
				+ "Image 68268203 resolution B: \n"+i
				+"\n££££££££££££££££££"
				+ "Image url: "+i.getUrl());
		
		ie.cit.caf.entity.Images i1 = imagesJpaRepo.findOne(1); 
		System.out.println("Image 1:"+i1);
		
		//I'm not sure why this is not working...
//		String url = imagesJpaRepo.findUrlByChoIdAndImageResolution(68268203, "B"); 
//		System.out.println("\n\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n"
//				+"url for image 68268203,B: "+url);
//		String why = "why is this not working"; 
//		System.out.println(why);
	}
	 @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	    protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	        @Autowired
	        private SecurityProperties security;

	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	        	
	        	  http
	              .authorizeRequests().antMatchers("/","/hello").permitAll().anyRequest()
	              .fullyAuthenticated().and().formLogin().loginPage("/login")
	              .failureUrl("/login?error").permitAll()
	              .and()
	              .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout");
	              ;
	        	
	        }
	        @Override
	        public void configure(AuthenticationManagerBuilder auth) throws Exception {
	            auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	        }
	    }
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/login").setViewName("login");
	    }
	    
	    @Bean
	    public ApplicationSecurity applicationSecurity() {
	    return new ApplicationSecurity();
	    }

}
