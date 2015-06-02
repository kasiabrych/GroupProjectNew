package ie.cit.caf.controller;

import ie.cit.caf.jparepo.ImagesJpaRepo;
import ie.cit.caf.repository.ImageRepository;
import ie.cit.caf.service.ImageService;
import ie.cit.caf.service.ImagesJpaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/images")
public class ImageController {
	
	@Autowired
	ImageService imageServ;
	
	@Autowired
	ImagesJpaService imageJpaServ;
	
	@RequestMapping(value="/listall", method = RequestMethod.GET) 
	public String listAll(ModelMap model) {			
			
			List<ie.cit.caf.domain.Image> listImage=imageServ.findAll();
			model.addAttribute("Images", listImage);
		    return "displayImages";			
		}    
	/*@RequestMapping (value="/medium/like/{mediumName}", method = RequestMethod.GET)
	public String participantByMediumLike(@PathVariable String mediumName, ModelMap model){
		
		List<ie.cit.caf.entity.Participant> choMediumList = participantJpaRepo.findByMediumContains(mediumName);
		
		model.addAttribute("Participants", participantMediumList);
		
		return "displayParticipants";
		
	}*/
	//commented out because the method below does the same job
//	@RequestMapping(value="/listall/B", method = RequestMethod.GET) 
//	public String listAllB(ModelMap model) {			
//			
//			List<ie.cit.caf.entity.Images> listImage=imageJpaRepo.findByImageResolution("B"); 
//			model.addAttribute("Images", listImage);
//		    return "displayImages";			
//		} 
	
	//displays images of a given resolution only using path variable
	@RequestMapping(value="/listall/{resolution}", method = RequestMethod.GET) 
	public String listAllResolution(@PathVariable String resolution, ModelMap model) {			
			
			List<ie.cit.caf.entity.Images> listImage=imageJpaServ.findByImageResolution(resolution); 
			model.addAttribute("Images", listImage);
		    return "displayImages";			
		}  
		
}                      