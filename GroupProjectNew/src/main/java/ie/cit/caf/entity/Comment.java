package ie.cit.caf.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
/**
 * Comment entity to be used with jpa repository. 
 * Includes validation criteria for validating comments. 
 * @author R00048777
 *
 */
@Component
@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId; 
	@Size(min=2, message="Please enter a valid comment")
	private String commentText;
	private int choId;
	private String username; 
	private Date date; 
	
	public Comment() {
		super();
	}
	
	public Comment(int commentId, String commentText, int choId,
			String username, Date date) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
		this.choId = choId;
		this.username = username;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentText="
				+ commentText + ", choId=" + choId + ", username=" + username
				+ ", date=" + date + "]";
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
