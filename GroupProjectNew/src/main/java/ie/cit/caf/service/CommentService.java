package ie.cit.caf.service;

import ie.cit.caf.entity.Comment;
import ie.cit.caf.entity.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {
	
	List<Comment> findCommentByChoId(int choid); 
	
	List<Comment> findCommentByCommentTextLike(String text); 
	
	List<Comment> findCommentByCommentTextContains(String text); 
	
	Iterable<Comment> findAll();

	void save(Comment comment); 
	
	void delete(Comment comment); 
	
	Comment findOne(int id); 
	

}
