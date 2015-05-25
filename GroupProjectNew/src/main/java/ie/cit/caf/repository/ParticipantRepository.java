package ie.cit.caf.repository;

import ie.cit.caf.domain.Participant;

import java.util.List;

public interface ParticipantRepository {

		public Participant get (int id); 
		
		public void save (Participant participant); 
		
		public void remove (Participant participant); 
		
		public List<Participant> findAll();

		public void saveInsert(Participant participant); 
		
		public Participant checkIfExist(int id); 
		
	}
