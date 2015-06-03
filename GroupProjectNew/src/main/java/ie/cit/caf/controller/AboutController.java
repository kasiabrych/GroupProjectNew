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
 * About controller: 
 * Controller class for About.
 * 
 *
 */

@Controller
@EnableAutoConfiguration
public class AboutController {

	@RequestMapping(value={"/contact"}, method = RequestMethod.GET)
	public String showContactPage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive contact page.");
		model.addAttribute("now", date);
		return "contact";
	}
	
	@RequestMapping(value={"/team"}, method = RequestMethod.GET)
	public String showTeamPage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive about page.");
		model.addAttribute("now", date);
		return "team";
	}
	
	@RequestMapping(value={"/story"}, method = RequestMethod.GET)
	public String showStoryPage(ModelMap model) { 
		Date date = new java.util.Date();		
		model.addAttribute("message", "This is Cooper-Hewit Interactive story page.");
		model.addAttribute("now", date);
		return "story";
	}
 }	
