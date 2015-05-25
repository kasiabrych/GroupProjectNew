package ie.cit.caf.domain;

public class Role {
	
	public Role() {
		super();
		role_no = 0; 
		System.out.println("constructing role");
		
	}
	private int role_no; 
	
	private String role_id;
	private String role_name; 
	private String role_display_name; 
	private String role_url;
	
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
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ",\n role_name=" + role_name
				+ ",\n role_display_name=" + role_display_name + ",\n role_url="
				+ role_url + "]";
	}
	public int getRole_no() {
		return role_no;
	}
	public void setRole_no(int role_no) {
		this.role_no = role_no;
	} 

}
