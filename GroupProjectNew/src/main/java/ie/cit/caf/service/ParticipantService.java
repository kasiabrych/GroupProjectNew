package ie.cit.caf.service;

import ie.cit.caf.domain.Participant;

import java.util.List;

public interface ParticipantService {

		public Participant get (int id); 
		
		public void save (Participant participant); 
		
		public void remove (Participant participant); 
		
		public List<Participant> findAll();

		public void saveInsert(Participant participant); 
		
	}
