package ie.cit.caf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId; 
	private String commentText;
	private int choId;
	
	
	public Comment() {
		super();
	}
	public Comment(int commentId, String commentText, int choId) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
		this.choId = choId;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentText="
				+ commentText + ", choId=" + choId + "]";
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public int getChoId() {
		return choId;
	}
	public void setChoId(int choId) {
		this.choId = choId;
	} 
	
	
}
