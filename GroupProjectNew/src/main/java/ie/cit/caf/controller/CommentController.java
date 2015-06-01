package ie.cit.caf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.cit.caf.entity.CHObject;
import ie.cit.caf.entity.Comment;
import ie.cit.caf.entity.User;
import ie.cit.caf.jparepo.ChoJpaRepo;
import ie.cit.caf.jparepo.CommentJpaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentJpaRepo commentJpaRepo; 
	@Autowired
	ChoJpaRepo choJpaRepo; 
	@Autowired
	Comment comment; 
	
//	@RequestMapping(value = "/addNew", method = RequestMethod.GET) 
//	public ModelAndView addComment() {   
//		return new ModelAndView("addComment", "comment", new Comment());
//	} 
	
	@RequestMapping(value = "{choid}/addNew", method = RequestMethod.GET) 
	public String addNewComment(@PathVariable int choid, ModelMap model) {  
		comment.setChoId(choid);
		model.addAttribute("comment", comment);	
		return "addComment";
	} 
	
	@RequestMapping(value = "{choid}/addNew", method = RequestMethod.POST)
	public String displayComment(@ModelAttribute("comment") Comment comment, ModelMap model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String userName = auth.getName(); //get logged in username
	    
	    Date date = new java.util.Date();	
	    comment.setDate(date);
	    comment.setUsername(userName);

		model.addAttribute("commentText", comment.getCommentText());
		model.addAttribute("choId", Integer.toString(comment.getChoId()));	
		model.addAttribute("userName", userName); 
		model.addAttribute("date", date); 
		System.out.println(userName+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+date);

		try {
			commentJpaRepo.save(comment); 
			int commentId=comment.getCommentId(); 
			model.addAttribute("commentId", Integer.toString(commentId));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "displayComment";
	}  
	@RequestMapping(value="/listall", method = RequestMethod.GET) 
	public String listAll(ModelMap model) {			
			
			Iterable<Comment> commentList=commentJpaRepo.findAll();
			model.addAttribute("comments", commentList);
		    return "displayComments";			
		}  
	
	@RequestMapping(value="/list/id/{choid}", method=RequestMethod.GET)
	public String listCommentByChoID(@PathVariable int choid, ModelMap model){		
		Date date = new java.util.Date();
		List <Comment> comments = commentJpaRepo.findCommentByChoId(choid); 
		model.addAttribute("comments", comments);
		model.addAttribute("now", date);
		return "displayComments";
	} 
	
	@RequestMapping (value="/text/contains/{text}", method = RequestMethod.GET)
	public String findCommentsByText(@PathVariable String text, ModelMap model){
		List<Comment> commentList = commentJpaRepo.findCommentByCommentTextContains(text);
		model.addAttribute("comments", commentList);
		return "displayComments";
	}
	
	@RequestMapping (value="/text/object/{text}", method = RequestMethod.GET)
	public String findObjectsByTag(@PathVariable String text, ModelMap model){
		List<Comment> commentList = commentJpaRepo.findCommentByCommentTextContains(text);
		List <CHObject> objectList = new ArrayList<CHObject>(); 
		
		for (Comment c : commentList){
			
			int objectId = c.getChoId(); 
			CHObject objectAdd = choJpaRepo.findOne(objectId); 
			objectList.add(objectAdd); 
		}
		
		model.addAttribute("CHOs", objectList);
		model.addAttribute("greeting", "Displaying objects tagged with \""+text+"\":"); 
		return "displayCHO";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET) 
	public String deleteComment(ModelMap model) {   
		Iterable <Comment> comments=commentJpaRepo.findAll();
		model.addAttribute("comments", comments);		
		return "deleteComment";
	} 
	@RequestMapping(value = "/delete/id/{id}", method = RequestMethod.GET) 
	public String deleteCommentById(@PathVariable int id, ModelMap model) { 
		Comment comDelete = commentJpaRepo.findOne(id); 
		System.out.println(comDelete);
		commentJpaRepo.delete(comDelete);
		//userJpaRepo.delete(id);
		model.addAttribute("greeting", "You have just deleted comment "+ id);
		model.addAttribute("commentId", comDelete.getCommentId());
		model.addAttribute("choId", comDelete.getChoId());
		model.addAttribute("commentText", comDelete.getCommentText());
		
		return "displayComment";
	} 
	@RequestMapping (value="/search", method = RequestMethod.GET)
	public String searchComments(ModelMap model){

		return "searchComments";

	}
}
