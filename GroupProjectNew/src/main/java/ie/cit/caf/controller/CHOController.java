package ie.cit.caf.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.entity.Images;
import ie.cit.caf.entity.Participation;
import ie.cit.caf.jparepo.ChoJpaRepo;
import ie.cit.caf.jparepo.ImagesJpaRepo;
import ie.cit.caf.repository.CHORepository;
import ie.cit.caf.service.CHObjectService;
import ie.cit.caf.service.ChoJpaService;
import ie.cit.caf.service.ImagesJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author R00048777 Kasia Brych
 * 
 * Controller class for CHObject 
 *
 */
@Controller
@RequestMapping("/cho")
public class CHOController {

	@Autowired
	CHObjectService choServ;

	@Autowired
	ChoJpaService choJpaServ;

	@Autowired
	ImagesJpaService imageServ;

	/**
	 * 
	 * @param model
	 * @return displayCHO template
	 * Method lists all objects in the database using jpa repository
	 */
	@RequestMapping(value="/listall", method = RequestMethod.GET) 
	public String listAll(ModelMap model) {			
		List<CHObject> listCHO=choServ.findAll();
		model.addAttribute("CHOs", listCHO);
		return "displayCHO";			
	}  

	/*	@RequestMapping(value="/view", method = RequestMethod.GET) 
	public String View(ModelMap model) {				
		CHObject listCHO=choRep.get(0);
		model.addAttribute("CHOs", listCHO);
		return "view";			
	}*/
	/**
	 * 
	 * @param mediumName
	 * @param model
	 * @return
	 * Method allows for search for cho's by words contained in the CHObject.medium attribute 
	 */
	@RequestMapping (value="/medium/like/{mediumName}", method = RequestMethod.GET)
	public String choByMediumLike(@PathVariable String mediumName, ModelMap model){
		//use jpa repository to obtain a list of objects 
		List<ie.cit.caf.entity.CHObject> choMediumList = choJpaServ.findByMediumContains(mediumName);
		//add list to model
		model.addAttribute("CHOs", choMediumList);
		return "displayCHO";
	}
	/**
	 * 
	 * @param keyword
	 * @param model
	 * @return
	 * Method allowing for keyword search
	 */
	@RequestMapping (value="/keyword/{keyword}", method = RequestMethod.GET)
	public String choByKeyword(@PathVariable String keyword, ModelMap model){
		//searching for objects containing the given word in cho attributes (medium, title, description, creditLine)
		List<ie.cit.caf.entity.CHObject> choMediumList = choJpaServ.findByMediumContains(keyword);
		List<ie.cit.caf.entity.CHObject> choTitleList = choJpaServ.findByTitleContains(keyword);
		List<ie.cit.caf.entity.CHObject> choDescList = choJpaServ.findByDescriptionContains(keyword);
		List<ie.cit.caf.entity.CHObject> choCreditList = choJpaServ.findByCreditlineContains(keyword);
		//adding ArrayList to form one ArrayList
		choMediumList.addAll(choTitleList); 
		choMediumList.addAll(choDescList); 
		choMediumList.addAll(choCreditList); 
		//converting ArrayList into a HashSet to avoid duplicates
		Set <CHObject>set = new HashSet(choMediumList);
		//passing the list
		model.addAttribute("CHOs", set);
		return "displayCHO";
	}
	/**
	 * Method returning the search page
	 * @param model
	 * @return
	 */
	@RequestMapping (value="/search", method = RequestMethod.GET)
	public String choByMedium(ModelMap model){
		return "findByMedium";

	}
	/**
	 * Method displaying details of an individual object, including 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/view/id/{id}", method = RequestMethod.GET)
	public String viewCHObject(@PathVariable int id, ModelMap model) {
		//find the requested object
		ie.cit.caf.entity.CHObject chobjectView=choJpaServ.findOne(id);
		//find the Participation list of the object and add to model (the list contains participants and roles)
		List <Participation>part=chobjectView.getParticipations(); 
		model.addAttribute("message", "CH Object with id "+ id +" can now be viewed");
		model.addAttribute("chobject", chobjectView);
		model.addAttribute("participations", part); 
		//find image for the object in the chosen resolution and add to model
		Images image =  imageServ.findByChoIdAndImageResolution(id, "B");
		if (image!=null){
			String imageUrl = image.getUrl(); 
			System.out.println(imageUrl);
			model.addAttribute("image", imageUrl); 
		}
		return "viewCHO"; 
	} 
	/**
	 * Test method for returning an image, incorporated into viewCHObject method above
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
	public String viewImage(@PathVariable int id, ModelMap model) {
		Images image =  imageServ.findByChoIdAndImageResolution(id, "B");
		String imageUrl = image.getUrl(); 
		System.out.println(imageUrl);
		model.addAttribute("image", imageUrl); 
		return "image"; } 

}                      
