package ie.cit.caf.controller;

import ie.cit.caf.entity.CHObject;
import ie.cit.caf.entity.Participation;
import ie.cit.caf.jparepo.ParticipantJpaRepo;
import ie.cit.caf.repository.ParticipantRepository;
import ie.cit.caf.service.ChoJpaService;
import ie.cit.caf.service.ParticipantService;
import ie.cit.caf.service.ParticipationJpaService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/participants")
public class ParticipantsController {
	
	@Autowired
	ParticipantService participantServ;
	
	@Autowired
	ParticipationJpaService partService; 
	
	@Autowired
	ChoJpaService choService; 

	@RequestMapping(value="/listall", method = RequestMethod.GET) 
	public String listAll(ModelMap model) {			
			
			List<ie.cit.caf.domain.Participant> listParticipant=participantServ.findAll();
			model.addAttribute("Participants", listParticipant);
		    return "displayParticipants";			
		}    
	/**
	 * This method is to display the search option
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/search", method = RequestMethod.GET) 
	public String search(ModelMap model) {			

		    return "searchParticipants";			
		} 
	/**
	 * This method conduct the search using the name given 
	 * and returns a view with a list of objects that the given participant was involved in
	 * @param model
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/search/objects/{name}", method = RequestMethod.GET) 
	public String searchForObjects(ModelMap model, @PathVariable String name) {	
		//create list of participations
		Iterable<Participation> listOfPart = partService.findParticipationByParticipantPersonNameContains(name);
		//create list to hold objects
		List<CHObject> objectList=new ArrayList<CHObject>(); 
		//iterate through participations list to get all relevant objects 
		for (Participation p : listOfPart){
			int pId = p.getParticipationId(); 
			List<CHObject>partObjectList=choService.findCHObjectsByParticipationsParticipationId(pId); 
			objectList.addAll(partObjectList); //adding partial lists to the full list, 
			//duplicates may happen for participants with the same name
		}
		model.addAttribute("CHOs", objectList); 
		model.addAttribute("greeting", "The list of objects for participant "+name); 
		
		    return "displayCHO";	
		    
		}    
		
		
}                      