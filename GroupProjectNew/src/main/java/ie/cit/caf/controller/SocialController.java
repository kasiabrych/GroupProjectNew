package ie.cit.caf.controller;

import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author R00131247 Graham Ó Síocháin
 * 
 * Social controller: 
 * Controller class for social.
 * 
 *
 */
@Controller
@EnableAutoConfiguration
public class SocialController {

	@RequestMapping(value={"/leaderboard"}, method = RequestMethod.GET)
	public String showLeaderboardPage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive contact page.");
		model.addAttribute("now", date);
		return "leaderboard";
	}
	
	@RequestMapping(value={"/share"}, method = RequestMethod.GET)
	public String showSharePage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive about page.");
		model.addAttribute("now", date);
		return "share";
	}
	
	@RequestMapping(value={"/subscribe"}, method = RequestMethod.GET)
	public String showSubscribePage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive story page.");
		model.addAttribute("now", date);
		return "subscribe";
	}
	
	@RequestMapping(value={"/signup"}, method = RequestMethod.GET)
	public String showSignupPage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive story page.");
		model.addAttribute("now", date);
		return "signup";
	}
 }	
