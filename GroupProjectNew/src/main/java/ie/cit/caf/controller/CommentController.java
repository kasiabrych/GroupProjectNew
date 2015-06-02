package ie.cit.caf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author R00048777
 * This is a controller class for comments. 
 *
 */
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
	/**
	 * Methods allowing to add a new comment. First passing a blank Comment object in
	 * @param choid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "{choid}/addNew", method = RequestMethod.GET) 
	public String addNewComment(@PathVariable int choid, ModelMap model) { 
		//getting id of the object for comment
		comment.setChoId(choid);
		model.addAttribute("comment", comment);	
		return "addComment";
	} 
	/**
	 * Method adding a new comment. Obtains current username and date
	 * @param comment
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "{choid}/addNew", method = RequestMethod.POST)
	public String displayComment(@ModelAttribute("comment")@Valid Comment comment,  
			BindingResult result, ModelMap model) {
		
		//form validation, return the form if there are errors
				if(result.hasErrors())
					return "addComment";  
				
		//get the username of the current user and set it as comment.username
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String userName = auth.getName(); 
	    comment.setUsername(userName);
	    //get the date and add it to comment
	    Date date = new java.util.Date();	
	    comment.setDate(date);
	    //setting other attrubutes
		model.addAttribute("commentText", comment.getCommentText());
		model.addAttribute("choId", Integer.toString(comment.getChoId()));	
		model.addAttribute("userName", userName); 
		model.addAttribute("date", date); 
		System.out.println(userName+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+date);
		//saving the comment using jpa repository methods
		try {
			commentJpaRepo.save(comment); 
			int commentId=comment.getCommentId(); 
			model.addAttribute("commentId", Integer.toString(commentId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//returning view with the details of the comment created displayed to the user
		return "displayComment";
	}  
	/**
	 * Lists all comments in the database 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/listall", method = RequestMethod.GET) 
	public String listAll(ModelMap model) {			
			//using jpa crud repository methods to obtain a list of comments
			Iterable<Comment> commentList=commentJpaRepo.findAll();
			model.addAttribute("comments", commentList);
		    return "displayComments";			
		}  
	/**
	 * Method below displays all comments for a particular object
	 * @param choid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list/id/{choid}", method=RequestMethod.GET)
	public String listCommentByChoID(@PathVariable int choid, ModelMap model){		
		Date date = new java.util.Date();
		List <Comment> comments = commentJpaRepo.findCommentByChoId(choid); 
		model.addAttribute("comments", comments);
		model.addAttribute("now", date);
		return "displayComments";
	} 
	/**
	 * Method below displays all comments that contain a word specified by the user
	 * @param text
	 * @param model
	 * @return
	 */
	@RequestMapping (value="/text/contains/{text}", method = RequestMethod.GET)
	public String findCommentsByText(@PathVariable String text, ModelMap model){
		List<Comment> commentList = commentJpaRepo.findCommentByCommentTextContains(text);
		model.addAttribute("comments", commentList);
		return "displayComments";
	}
	/**
	 * Method returns a view with a list of objects that have been tagged with a particular word/comment
	 * @param text
	 * @param model
	 * @return
	 */
	@RequestMapping (value="/text/object/{text}", method = RequestMethod.GET)
	public String findObjectsByTag(@PathVariable String text, ModelMap model){
		//obtaining a list of comments that contain the given word
		List<Comment> commentList = commentJpaRepo.findCommentByCommentTextContains(text);
		//creating a list to hold objects
		List <CHObject> objectList = new ArrayList<CHObject>(); 
		//iterating through commentList to generate a list of objects that the given word/comment refers to
		for (Comment c : commentList){
			//getting id for object
			int objectId = c.getChoId(); 
			//finding object
			CHObject objectAdd = choJpaRepo.findOne(objectId); 
			//adding object to list
			objectList.add(objectAdd); 
		}
		//adding the list of objects and a greeting that contains the word searched for
		model.addAttribute("CHOs", objectList);
		model.addAttribute("greeting", "Displaying objects tagged with \""+text+"\":"); 
		return "displayCHO";
	}
	/**
	 * Delete methods for comments. First generate a list of all comments with a link to delete 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET) 
	public String deleteComment(ModelMap model) {   
		Iterable <Comment> comments=commentJpaRepo.findAll();
		model.addAttribute("comments", comments);		
		return "deleteComment";
	} 
	/**
	 * Method deleting comments based on id
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete/id/{id}", method = RequestMethod.GET) 
	public String deleteCommentById(@PathVariable int id, ModelMap model) { 
		//find comment to be deleted
		Comment comDelete = commentJpaRepo.findOne(id); 
		System.out.println(comDelete);
		//delete comment using crud repo delete
		commentJpaRepo.delete(comDelete);
		//list of information to be displayed to the user in confirmation
		model.addAttribute("greeting", "You have just deleted comment "+ id);
		model.addAttribute("commentId", comDelete.getCommentId());
		model.addAttribute("choId", comDelete.getChoId());
		model.addAttribute("commentText", comDelete.getCommentText());
		model.addAttribute("date", comDelete.getDate());
		model.addAttribute("userName", comDelete.getUsername());
		return "displayComment";
	} 
	/**
	 * Method returns a searching page for comments. 
	 * @param model
	 * @return
	 */
	@RequestMapping (value="/search", method = RequestMethod.GET)
	public String searchComments(ModelMap model){
		return "searchComments";

	}
}
