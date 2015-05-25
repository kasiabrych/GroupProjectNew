package ie.cit.caf.jparepo;

import ie.cit.caf.entity.Participant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ParticipantJpaRepo extends CrudRepository<Participant, Integer>{
	
	Iterable <Participant> findByPersonNameLike(String name); 

}
