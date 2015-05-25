package ie.cit.caf.service;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Images;

import java.util.List;

public interface ImagesService {
	
	public Images get (int id); 

	public void saveImagesWithCHOId (Images image, CHObject cho); 

	public void remove (Images image); 

	public List<Images> findAll();

	public void linkImageToCho(Images i, CHObject cho); 

}
