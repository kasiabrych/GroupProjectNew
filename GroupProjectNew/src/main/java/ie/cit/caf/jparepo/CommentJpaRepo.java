package ie.cit.caf.jparepo;

import java.util.List;

import ie.cit.caf.entity.Comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentJpaRepo extends CrudRepository<Comment, Integer>{
	
	public List<Comment> findCommentByChoId(int choid); 
	
	public List<Comment> findCommentByCommentTextLike(String text); 
	
	public List<Comment> findCommentByCommentTextContains(String text); 

}
