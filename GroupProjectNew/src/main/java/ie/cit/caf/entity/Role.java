package ie.cit.caf.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
/**
 * Role entity to be used with jpa repository. 
 * @author R00048777
 *
 */
@Entity
@Table(name="roles")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_no; 
	private String role_id;
	private String role_name; 
	private String role_display_name; 
	private String role_url;
	
	
	@Override
	public String toString() {
		return "Role [role_no=" + role_no + ", role_id=" + role_id
				+ ", role_name=" + role_name + ", role_display_name="
				+ role_display_name + ", role_url=" + role_url + "]";
	}
	public int getRole_no() {
		return role_no;
	}
	public void setRole_no(int role_no) {
		this.role_no = role_no;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_display_name() {
		return role_display_name;
	}
	public void setRole_display_name(String role_display_name) {
		this.role_display_name = role_display_name;
	}
	public String getRole_url() {
		return role_url;
	}
	public void setRole_url(String role_url) {
		this.role_url = role_url;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
