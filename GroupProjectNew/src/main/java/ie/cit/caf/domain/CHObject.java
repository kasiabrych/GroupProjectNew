package ie.cit.caf.domain;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty; 
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class CHObject {

	private int id; 
	private String title;
	private String date; 
	private String medium; 
	private String creditline;
	private String description;
	private String gallery_text;
	@JsonUnwrapped
	@JsonProperty ("participants")
	private List<Participation> participations; 
	//private List<Map<String, Image>> images; 

	private List <Images> images; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getCreditline() {
		return creditline;
	}

	public void setCreditline(String creditline) {
		this.creditline = creditline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGallery_text() {
		return gallery_text;
	}

	public void setGallery_text(String gallery_text) {
		this.gallery_text = gallery_text;
	}

	@Override
	public String toString() {
		String choAsString =  "CHObject [id=" + id + ",\n title=" + title + ",\n date=" + date
				+ ",\n medium=" + medium + ",\n creditline=" + creditline
				+ ",\n description=" + description + ",\n gallery_text="
				+ gallery_text + "]";
		for (Participation p : getParticipations()) {
			choAsString += "\n-- "+ p.toString(); 
		}
//		for (Map<String, Image> map : images){
//			choAsString += "\n-- " + map.toString(); 
		for (Images i: getImages()){
			choAsString += "\n-- "+i.toString(); 
		}
		return choAsString; 
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public List <Images> getImages() {
		return images;
	}

	public void setImages(List <Images> images) {
		this.images = images;
	}

//	public List<Map<String, Image>> getImages() {
//		return images;
//	}
//
//	public void setImages(List<Map<String, Image>> images) {
//		this.images = images;
//	} 
}
