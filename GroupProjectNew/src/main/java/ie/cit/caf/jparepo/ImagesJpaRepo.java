package ie.cit.caf.jparepo;

import java.util.List;

import ie.cit.caf.entity.Images;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesJpaRepo extends CrudRepository <Images, Integer>{
	
	public List<Images> findByWidth(String width);
	
	public List<Images> findByImageResolution(String resolution);
	
	public List <Images> findByChoId(int choId); 
	
	public Images findByChoIdAndImageResolution(int choId, String resolution); 
	
	public String findUrlByChoIdAndImageResolution(int choId, String resolution); 

}
