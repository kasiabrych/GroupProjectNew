package ie.cit.caf.domain;

public class Image {
	
	private int image_no; 
	private String url; 
	private String width; 
	private String height; 
	private String is_primary; 
	private String image_id;
	
	
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
		return "Image [url=" + url + ",\n width=" + width + ",\n hight=" + height
				+ ",\n is_primary=" + is_primary + ",\n image_id=" + image_id + "]";
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String hight) {
		this.height = hight;
	}
	public int getImage_no() {
		return image_no;
	}
	public void setImage_no(int image_no) {
		this.image_no = image_no;
	} 

}
