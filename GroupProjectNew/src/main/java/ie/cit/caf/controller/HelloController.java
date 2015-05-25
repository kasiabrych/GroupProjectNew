package ie.cit.caf.controller;

import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@EnableAutoConfiguration
public class HelloController {
	
	 @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
		public String showHomePage(ModelMap model) { 
			Date date = new java.util.Date();		
			model.addAttribute("message", "This is Cooper-Hewit Interactive home page.");
			model.addAttribute("now", date);
			return "hello";
		} 	
	 }	  