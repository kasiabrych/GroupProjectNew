package ie.cit.caf.service;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Images;
import ie.cit.caf.repository.ImagesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesServiceImpl implements ImagesService{
	
	ImagesRepository imagesRepository;
	
	@Autowired
	public ImagesServiceImpl(ImagesRepository imagesRepository) {
	this. imagesRepository =  imagesRepository;
	}

	@Override
	public Images get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveImagesWithCHOId(Images images, CHObject cho) {
		imagesRepository.saveImagesWithCHOId(images, cho);
	}

	@Override
	public void remove(Images image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Images> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void linkImageToCho(Images i, CHObject cho) {
		// TODO Auto-generated method stub
		
	}

}
