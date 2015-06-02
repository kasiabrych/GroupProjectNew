package ie.cit.caf.service;

import ie.cit.caf.entity.Images;
import ie.cit.caf.jparepo.CommentJpaRepo;
import ie.cit.caf.jparepo.ImagesJpaRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of service for Images entity. 
 * ImagesJpaRepo autowired. 
 * @author R00048777
 *
 */
@Service
public class ImagesJpaServiceImpl implements ImagesJpaService{
	

	@Autowired
	ImagesJpaRepo repo;

	public ImagesJpaServiceImpl(ImagesJpaRepo repo) {
		super();
		this.repo = repo;
	}
	public ImagesJpaServiceImpl() {
		super();
	}

	@Override
	public List<Images> findByWidth(String width) {
		// TODO Auto-generated method stub
		return repo.findByWidth(width);
	}

	@Override
	public List<Images> findByImageResolution(String resolution) {
		// TODO Auto-generated method stub
		return repo.findByImageResolution(resolution);
	}

	@Override
	public List<Images> findByChoId(int choId) {
		// TODO Auto-generated method stub
		return repo.findByChoId(choId);
	}

	@Override
	public Images findByChoIdAndImageResolution(int choId, String resolution) {
		// TODO Auto-generated method stub
		return repo.findByChoIdAndImageResolution(choId, resolution);
	}

	@Override
	public String findUrlByChoIdAndImageResolution(int choId, String resolution) {
		// TODO Auto-generated method stub
		return repo.findUrlByChoIdAndImageResolution(choId, resolution);
	}

}
