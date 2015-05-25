package ie.cit.caf.service;

import ie.cit.caf.domain.CHObject;
import ie.cit.caf.domain.Image;
import ie.cit.caf.repository.ImageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ImageServiceImpl implements ImageService{

ImageRepository imageRepository;
	
	@Autowired
	public ImageServiceImpl(ImageRepository imageRepository) {
	this. imageRepository =  imageRepository;
	}
	@Override
	public Image get(int id) {
		return imageRepository.get(id);
	}

	@Override
	public void save(Image image) {
		imageRepository.save(image);
	}

	@Override
	public void remove(Image image) {
		imageRepository.remove(image);
	}

	@Override
	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	@Override
	public void linkImageToCho(Image i, CHObject cho) {
		imageRepository.linkImageToCho(i, cho);
		
	}

}
