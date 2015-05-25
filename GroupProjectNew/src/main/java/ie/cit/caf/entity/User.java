package ie.cit.caf.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int userId; 
	@Size(min=2, max=30, message="Please enter a user name between 2 and 30 characters")
	public String userName; 
	@Size(min=2, max=20, message="The password must be between 2 and 20 characters")
	public String password;
//	@ElementCollection
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinTable(name="interests",
//			joinColumns={@JoinColumn(name="userId", referencedColumnName="userId")},
//			inverseJoinColumns={@JoinColumn(name="interestId", referencedColumnName="interestId")})
//	private List<Interest> interests;
	public Boolean newsletter;
	
	
	public User(int userId, String userName, String password, Boolean newsletter) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.newsletter = newsletter;
	}
	public User() {
		super();
		System.out.println("Empty constructor getting user to create users");
	}
	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getNewsletter() {
		return newsletter;
	}
	public void setNewsletter(Boolean newsletter) {
		this.newsletter = newsletter;
	}
//	public List<Interest> getInterests() {
//		return interests;
//	}
//	public void setInterests(List<Interest> interests) {
//		this.interests = interests;
//	}
	
}
