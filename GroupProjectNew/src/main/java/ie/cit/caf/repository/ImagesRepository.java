package ie.cit.caf.repository;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Images;

import java.util.List;

public interface ImagesRepository {
	
	public Images get (int id); 
	
	public void saveImages (Images image); 
	
	public void remove (Images image); 
	
	public List<Images> findAll();

	public void linkImageToCho(Images i, CHObject cho);

	void saveImagesWithCHOId(Images images, CHObject cho); 

}
