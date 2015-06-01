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
/**
 * 
 * @author R00048777
 * Controller for the User object
 *
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserJpaRepo userJpaRepo; 
	@Autowired
	User user; 
	
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
 * Method below returns a list of all users in the system
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
/**
 * Finding a user with a particular username
 * @param username
 * @param model
 * @return
 */
	@RequestMapping(value="/list/{userName}", method=RequestMethod.GET)
	public String listUserByUserName(@PathVariable String username,  ModelMap model){		
		Date date = new java.util.Date();		
		User users=userJpaRepo.findByUsername(username); 
		model.addAttribute("users", users);
		model.addAttribute("now", date);
		return "displayUsers";
	}    
/**
 * Finding a user with a particular id
 * @param id
 * @param model
 * @return
 */
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
/**
 * Method adding a new user. Includes form validation
 * @param user
 * @param result
 * @param model
 * @return
 */
	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public String displayUser(@ModelAttribute("user") @Valid User user,  
			BindingResult result, ModelMap model) {
		//form validation, return the form if there are errors
		if(result.hasErrors())
			return "addNewUser";                           
		//attributes
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword()); 
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("userId", user.getUserId());
		model.addAttribute("newsletter", user.getNewsletter());
		model.addAttribute("designFan", user.getDesignFan());
		//setting attributes necessary for authentication
		user.setEnabled(true);
		user.setRole("ROLE_USER");

		try {
			//saving the user with crud repo methods
			userJpaRepo.save(user); 
			//retrieving user id
			int id=user.getUserId();
			//attaching id to be displayed
			model.addAttribute("userId", Integer.toString(id));
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "displayUser";
	} 
	/**
	 * Method passing a blank user bean to for adding a new user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addNew", method = RequestMethod.GET) 
	public String addNewUser(ModelMap model) {  
		model.addAttribute("user", user);	
		return "addNewUser";
	} 
	/**
	 * Method displaying a list of users that can be deleted
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET) 
	public String deleteUser(ModelMap model) {   
		Iterable <User> users=userJpaRepo.findAll();
		model.addAttribute("users", users);		
		return "delete";
	} 
	/**
	 * Method deleting a given user
	 * @param id
	 * @param model
	 * @return
	 */
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
	/**
	 * Method displaying a list of users that can be modified
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/modify", method = RequestMethod.GET) 
	public String modify(ModelMap model) {			
		List<User> users=userJpaRepo.findAll();
		model.addAttribute("users", users);
		return "modify";			
	}  
	/**
	 * Method displaying the details of the chosen user. 
	 * @param id
	 * @param model
	 * @return
	 */
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

	/**
	 * Method modifying the user and saving the new details to the database
	 * @param id
	 * @param password
	 * @param newsletter
	 * @param designFan
	 * @param model
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value={"/modify/id/{id}/password/{password}/{designFan}/{newsletter}"},  method = RequestMethod.GET) 
	public String modifyUser(@ModelAttribute("user") 
		@PathVariable int id, @PathVariable String password, 
		 @PathVariable boolean newsletter, @PathVariable boolean designFan, 
			ModelMap model, @Valid User user,  
			BindingResult result) {	
		//return the form if there are errors
		if(result.hasErrors()){
			user = userJpaRepo.findOne(id); 
			model.addAttribute("user", user);
			return "modifyForm";
		}
		//retrieving the user, saving changes
		user = userJpaRepo.findOne(id); 
		user.setPassword(password);
		user.setDesignFan(designFan);
		user.setNewsletter(newsletter);
		userJpaRepo.save(user); 
		//info to be displayed to the user in confirmation of modification
		model.addAttribute("message", "User with id "+ id +" has been modified");
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("userId", user.getUserId());
		model.addAttribute("newsletter", user.getNewsletter());
		model.addAttribute("designFan", user.getDesignFan());
		return "displayUser";		
	}  
	
	
}
