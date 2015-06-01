package ie.cit.caf.controller;

import ie.cit.caf.entity.User;
import ie.cit.caf.jparepo.UserJpaRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserJpaRepo userJpaRepo; 
	@Autowired
	User user; 
	List<String> interests=new ArrayList <String>();
	
/*	@RequestMapping(value={"/signup"}, method = RequestMethod.GET)
	public String showSignupPage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive signup page.");
		model.addAttribute("now", date);
		return "signup";
	}*/
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(
	       @RequestParam(value = "error", required = false) String error,
	       @RequestParam(value = "logout", required = false) String logout) {
	             
	       ModelAndView model = new ModelAndView();
	       if (error != null) {
	                     model.addObject("error", "Invalid username and password!");
	              }
	      
	       if (logout != null) {
	              model.addObject("msg", "You've been logged out successfully.");
	       }
	       model.setViewName("login");
	      
	       return model;
	}

	/*@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String showContactPage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive login page.");
		model.addAttribute("now", date);
		return "login";
	}*/
	
	@RequestMapping(value={"/logout"}, method = RequestMethod.GET)
	public String showTeamPage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive logout page.");
		model.addAttribute("now", date);
		return "logout";
	}
	
	/*@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive login page.");
		model.addAttribute("now", date);
		return "login";
	}*/

/**
 * 
 * @param model
 * @return list of all users
 * 
 */
	@RequestMapping(value="/listall", method = RequestMethod.GET) 
	public String listAll(ModelMap model) {				
		Iterable<User> listUsers=userJpaRepo.findAll(); 
		model.addAttribute("users", listUsers);
		return "displayUsers";			
	}  

//	@RequestMapping(value="/song/{name}", method = RequestMethod.GET) 
//	public String listSongwriterBySong(@PathVariable("name") String songName, ModelMap model){
//		Date date = new java.util.Date();	
//		List <SongwriterImpl> songwriters=songwriterDAO.listSongWriters(songName);
//		model.addAttribute("songwriters", songwriters);
//		model.addAttribute("now", date);
//		return "displaysongwriters";	
//	}   

	/*@RequestMapping(value="/song/{name}", method=RequestMethod.GET)
		 public String listSongwriterBySong1(@PathVariable String name,  ModelMap model){		
			Date date = new java.util.Date();	
			List<SongwriterImpl> songwriters=songwriterDAO.listSongWriters(name);
			model.addAttribute("songwriters", songwriters);
			model.addAttribute("now", date);
		    return "displaysongwriter";
		}*/

	@RequestMapping(value="/list/{userName}", method=RequestMethod.GET)
	public String listUserByUserName(@PathVariable String username,  ModelMap model){		
		Date date = new java.util.Date();		
		User users=userJpaRepo.findByUsername(username); 
		model.addAttribute("users", users);
		model.addAttribute("now", date);
		return "displayUsers";
	}    

	@RequestMapping(value="/list/id/{id}", method=RequestMethod.GET)
	public String listUserByID(@PathVariable int id, ModelMap model){		
		Date date = new java.util.Date();
		List <User> users=new ArrayList<User>();
		User u=userJpaRepo.findOne(id); 
		users.add(u);
		model.addAttribute("users", users);
		model.addAttribute("now", date);
		return "displayUsers";
	} 
//	@RequestMapping(value = "/addNew", method = RequestMethod.GET) 
//	public ModelAndView addNewUser() {   
//		return new ModelAndView("addNewUser", "user", new User());
//	} 
	
	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public String displayUser(@ModelAttribute("user") @Valid User user,  
			BindingResult result, ModelMap model) {
		
		if(result.hasErrors())
			return "addNewUser";                           
		
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword()); 
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("userId", user.getUserId());
		model.addAttribute("newsletter", user.getNewsletter());
		model.addAttribute("designFan", user.getDesignFan());
//		
//		if(user.getInterests()!=null && user.getInterests().size()>0){
//            model.addAttribute("interests", user.getInterests());
//        }

		try {
			//int id=songwriterDAO.createSongwriterGetID(songwriter.getFirstname(), songwriter.getFirstname(), songwriter.getAge());
			userJpaRepo.save(user); 
			int id=user.getUserId(); 
			model.addAttribute("userId", Integer.toString(id));
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "displayUser";
	}        
	@RequestMapping(value = "/addNew", method = RequestMethod.GET) 
	public String addNewUser(ModelMap model) {  

//		List<String> interests=new ArrayList<String>();
//		interests.add("interest1");
//		interests.add("interst2");
//		user.setInterests(interests);	
		model.addAttribute("user", user);	
		return "addNewUser";
	} 
	@RequestMapping(value = "/delete", method = RequestMethod.GET) 
	public String deleteUser(ModelMap model) {   
		Iterable <User> users=userJpaRepo.findAll();
		model.addAttribute("users", users);		
		return "delete";
	} 
	@RequestMapping(value = "/delete/id/{id}", method = RequestMethod.GET) 
	public String deleteUserById(@PathVariable int id, ModelMap model) { 
		User userDelete = userJpaRepo.findOne(id); 
		System.out.println(userDelete);
		//userJpaRepo.delete(userDelete);
		//userJpaRepo.delete(id);
		model.addAttribute("greeting", "User with id "+ id +" and details below have been deleted from the system");
		model.addAttribute("username", userDelete.getUsername());
		model.addAttribute("password", userDelete.getPassword());
		model.addAttribute("userId", userDelete.getUserId());
		model.addAttribute("newsletter", userDelete.getNewsletter());
		model.addAttribute("designFan", userDelete.getDesignFan());
		return "displayUser";
	} 
	@RequestMapping(value="/modify", method = RequestMethod.GET) 
	public String modify(ModelMap model) {			
		List<User> users=userJpaRepo.findAll();
		model.addAttribute("users", users);
		return "modify";			
	}  
	@RequestMapping(value = "/modify/id/{id}", method = RequestMethod.GET) 
	public String modifyUser(@PathVariable int id, ModelMap model) { 
		User userModify = userJpaRepo.findOne(id); 
		model.addAttribute("user", userModify);
		return "modifyForm";	} 	
	
	//trying to get the validation messages to display, no success
//	@RequestMapping(value = "/modify/id/{id}/password/{password}", method = RequestMethod.GET) 
//	public ModelAndView modifyUGet(@PathVariable int id) {  
//		User user = new User(); 
//		return new ModelAndView("modifyForm", "user", user);
//	} 
//	
	@RequestMapping(value={"/modify/id/{id}/password/{password}/{designFan}/{newsletter}"},  method = RequestMethod.GET) 
	public String modifyUser(@ModelAttribute("user") 
		@PathVariable int id, @PathVariable String password, 
		 @PathVariable boolean newsletter, @PathVariable boolean designFan, 
			ModelMap model, @Valid User user,  
			BindingResult result) {	
		
		if(result.hasErrors()){
			user = userJpaRepo.findOne(id); 
			model.addAttribute("user", user);
			return "modifyForm";
		}
		//userJpaRepo.updatePassword(id, password); 
		user = userJpaRepo.findOne(id); 
		user.setPassword(password);
		user.setDesignFan(designFan);
		user.setNewsletter(newsletter);
		userJpaRepo.save(user); 
		model.addAttribute("message", "User with id "+ id +" has been modified");
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("userId", user.getUserId());
		model.addAttribute("newsletter", user.getNewsletter());
		model.addAttribute("designFan", user.getDesignFan());
		return "displayUser";		
	}  
	
	
}
