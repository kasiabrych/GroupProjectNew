package ie.cit.caf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
/**
 * Participant entity to be used with jpa repository
 * @author R00048777
 *
 */
@Entity
@Table(name="participants")
public class Participant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="participant_id")
	private int participantId; 
	private String person_id; 
	@Column(name="person_name")
	private String personName; 
	private String person_date; 
	private String person_url;

	@Override
	public String toString() {
		return "Participant [participant_id=" + participantId + ", person_id="
				+ person_id + ", person_name=" + personName + ", person_date="
				+ person_date + ", person_url=" + person_url + "]";
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return personName;
	}
	public void setPerson_name(String personName) {
		this.personName = personName;
	}
	public String getPerson_date() {
		return person_date;
	}
	public void setPerson_date(String person_date) {
		this.person_date = person_date;
	}
	public String getPerson_url() {
		return person_url;
	}
	public void setPerson_url(String person_url) {
		this.person_url = person_url;
	}
	
}
