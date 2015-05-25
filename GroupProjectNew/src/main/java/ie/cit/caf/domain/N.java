package ie.cit.caf.domain;

public class N {
	
	private Number height;
   	private String image_id;
   	private String is_primary;
   	private String url;
   	private Number width;
   	private int image_no; 
   	
   	public String toString() {
		String n = "\n-----Details-----" + "\nImage ID: : " + image_id + 
				"\nImage Width: " + width + "\nImage Height: " + height + 
				"\nIs Primary: " + is_primary + "\nImage URL: " + url + "\n";
		return n;
		
		}

 	public Number getHeight(){
		return this.height;
	}
	public void setHeight(Number height){
		this.height = height;
	}
 	public String getImage_id(){
		return this.image_id;
	}
	public void setImage_id(String image_id){
		this.image_id = image_id;
	}
 	public String getIs_primary(){
		return this.is_primary;
	}
	public void setIs_primary(String is_primary){
		this.is_primary = is_primary;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
 	public Number getWidth(){
		return this.width;
	}
	public void setWidth(Number width){
		this.width = width;
	}

	public int getImage_no() {
		return image_no;
	}

	public void setImage_no(int image_no) {
		this.image_no = image_no;
	}


}
