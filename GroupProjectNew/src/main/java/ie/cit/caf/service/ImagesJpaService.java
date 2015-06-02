package ie.cit.caf.service;

import ie.cit.caf.entity.Images;

import java.util.List;
/**
 * Service interface for Images entity. 
 * @author R00048777
 *
 */
public interface ImagesJpaService {

	public List<Images> findByWidth(String width);
	
	public List<Images> findByImageResolution(String resolution);
	
	public List <Images> findByChoId(int choId); 
	
	public Images findByChoIdAndImageResolution(int choId, String resolution); 
	
	public String findUrlByChoIdAndImageResolution(int choId, String resolution); 

}
