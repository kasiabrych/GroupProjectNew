package ie.cit.caf.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
/**
 * User entity to be used with jpa repository
 * Includes criteria for form validation. 
 * User class includes a String role attribute and a method to convert the String 
 * into an ArrayList that can be used in MyUserDetailsService to build a user for authentication
 * @author R00048777
 *
 */
@Component
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId; 
	@Size(min=2, max=30, message="Please enter a user name between 2 and 30 characters")
	private String username; 
	@Size(min=2, max=20, message="The password must be between 2 and 20 characters")
	private String password;
	private boolean enabled; 
//	@ElementCollection
//	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	private String role; 
	
	private Boolean newsletter;
	private Boolean designFan; 
	
	public User(int userId, String username, String password, Boolean newsletter) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.newsletter = newsletter;
	}
	public User() {
		super();
		System.out.println("Empty constructor creating users");
	}
	
	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
 
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", password=" + password + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name = "username", unique = true, 
			nullable = false, length = 45)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password", 
			nullable = false, length = 60)
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
	public Boolean getDesignFan() {
		return designFan;
	}
	public void setDesignFan(Boolean designFan) {
		this.designFan = designFan;
	}
	
	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
//	@ElementCollection
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//	public Set<UserRole> getUserRole() {
//		return this.userRole;
//	}
// 
//	public void setUserRole(Set<UserRole> userRole) {
//		this.userRole = userRole;
//	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * Converts String role into an arrayList that is required for user authentication. 
	 * @param role2
	 * @return
	 */
	public ArrayList<String> convertRole(String role2) {
		ArrayList<String> roleConverted = new ArrayList<String>(); 
		roleConverted.add(role2); 
		return roleConverted; 
	}
}
