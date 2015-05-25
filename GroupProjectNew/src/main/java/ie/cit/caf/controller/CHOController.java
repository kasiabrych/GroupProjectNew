package ie.cit.caf.controller;

import java.util.List;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.entity.Participation;
import ie.cit.caf.jparepo.ChoJpaRepo;
import ie.cit.caf.repository.CHORepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cho")
public class CHOController {

	@Autowired
	CHORepository choRep;

	@Autowired
	ChoJpaRepo choJpaRepo;

	@RequestMapping(value="/listall", method = RequestMethod.GET) 
	public String listAll(ModelMap model) {			

		List<CHObject> listCHO=choRep.findAll();
		model.addAttribute("CHOs", listCHO);
		return "displayCHO";			
	}  

	/*	@RequestMapping(value="/view", method = RequestMethod.GET) 
	public String View(ModelMap model) {				
		CHObject listCHO=choRep.get(0);
		model.addAttribute("CHOs", listCHO);
		return "view";			
	}*/

	@RequestMapping (value="/medium/like/{mediumName}", method = RequestMethod.GET)
	public String choByMediumLike(@PathVariable String mediumName, ModelMap model){

		List<ie.cit.caf.entity.CHObject> choMediumList = choJpaRepo.findByMediumContains(mediumName);

		model.addAttribute("CHOs", choMediumList);

		return "displayCHO";

	}
	//	//METHOD IM HAVING ISSUE WITH
	//		@RequestMapping(value = "/view/id/{id}", method = RequestMethod.GET)
	//	    public String viewCHObject(@PathVariable int id, ModelMap model) {
	//	           CHObject chobjectView=choRep.get(id);
	//	           model.addAttribute("message", "CH Object with id "+ id +" can now be viewed");
	//	           model.addAttribute("chobject", chobjectView);
	//	           return "viewCHO"; } 

	//trying to get participants/roles displaying
	@RequestMapping(value = "/view/id/{id}", method = RequestMethod.GET)
	public String viewCHObject(@PathVariable int id, ModelMap model) {
		ie.cit.caf.entity.CHObject chobjectView=choJpaRepo.findOne(id);
		List <Participation>part=chobjectView.getParticipations(); 
		model.addAttribute("message", "CH Object with id "+ id +" can now be viewed");
		model.addAttribute("chobject", chobjectView);
		model.addAttribute("participations", part); 
		return "viewCHO"; } 

}                      
