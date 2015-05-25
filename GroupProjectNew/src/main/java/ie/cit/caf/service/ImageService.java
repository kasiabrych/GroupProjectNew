package ie.cit.caf.service;


import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Image;

import java.util.List;

public interface ImageService {

	public Image get (int id); 

	public void save (Image image); 

	public void remove (Image image); 

	public List<Image> findAll();

	public void linkImageToCho(Image i, CHObject cho); 

}
