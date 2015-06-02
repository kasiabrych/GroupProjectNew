package ie.cit.caf.service;

import ie.cit.caf.entity.Comment;
import ie.cit.caf.jparepo.CommentJpaRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentJpaRepo repo;

	public CommentServiceImpl(CommentJpaRepo repo) {
		super();
		this.repo = repo;
	}
	public CommentServiceImpl() {
		super();
	}

	@Override
	public List<Comment> findCommentByChoId(int choid) {
		// TODO Auto-generated method stub
		return repo.findCommentByChoId(choid);
	}

	@Override
	public List<Comment> findCommentByCommentTextLike(String text) {
		// TODO Auto-generated method stub
		return repo.findCommentByCommentTextLike(text);
	}

	@Override
	public List<Comment> findCommentByCommentTextContains(String text) {
		// TODO Auto-generated method stub
		return repo.findCommentByCommentTextContains(text);
	}

	@Override
	public Iterable<Comment> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(Comment comment) {
		// TODO Auto-generated method stub
		repo.save(comment); 
	}

	@Override
	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		repo.delete(comment);
	}

	@Override
	public Comment findOne(int id) {
		// TODO Auto-generated method stub
		return repo.findOne(id);
	}

}
