package ie.cit.caf.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Images {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int image_no; 
	private String url; 
	private String width; 
	private String height; 
	private String is_primary; 
	private String image_id;
	@Column(name="image_resolution")
	private String imageResolution; 
	@Column(name="cho_id")
	private int choId; 
	
	public int getImage_no() {
		return image_no;
	}
	public void setImage_no(int image_no) {
		this.image_no = image_no;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getIs_primary() {
		return is_primary;
	}
	public void setIs_primary(String is_primary) {
		this.is_primary = is_primary;
	}
	public String getImage_id() {
		return image_id;
	}
	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}
	@Override
	public String toString() {
		return "Images [image_no=" + image_no + ",\n url=" + url + ",\n width="
				+ width + ",\n height=" + height + ",\n is_primary=" + is_primary
				+ ",\n image_id=" + image_id + ",\n imageResolution="
				+ imageResolution + ",\n choId=" + choId + "]\n\n";
	}
	public String getImage_resolution() {
		return imageResolution;
	}
	public void setImage_resolution(String imageResolution) {
		this.imageResolution = imageResolution;
	}
	public int getCho_id() {
		return choId;
	}
	public void setCho_id(int choId) {
		this.choId = choId;
	}

}
