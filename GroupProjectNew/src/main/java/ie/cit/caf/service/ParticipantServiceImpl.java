package ie.cit.caf.service;

import ie.cit.caf.domain.Participant;
import ie.cit.caf.repository.ParticipantRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ParticipantServiceImpl implements ParticipantService{

	ParticipantRepository participantRepository;

	@Autowired
	public ParticipantServiceImpl(ParticipantRepository participantRepository) {
		this.participantRepository = participantRepository;
	}


	@Override
	public Participant get(int id) {
		return participantRepository.get(id);
	}

	@Override
	public void save(Participant participant) {
		if (participantRepository.checkIfExist(Integer.parseInt(participant.getPerson_id()))==null)
		participantRepository.save(participant);
	}

	@Override
	public void remove(Participant participant) {
		participantRepository.remove(participant);
	}

	@Override
	public List<Participant> findAll() {
		return participantRepository.findAll();
	}

	@Override
	public void saveInsert(Participant participant) {
		participantRepository.saveInsert(participant);

	}

}
