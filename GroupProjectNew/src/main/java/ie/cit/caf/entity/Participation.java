package ie.cit.caf.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
/**
 * Participation entity to be used with jpa repository. 
 * Includes table joining in order to populate cho.participation list
 * @author R00048777
 *
 */
@Entity
@Table(name="object_participant_role")
public class Participation {
	
	@Id
	@Column(name="participation_id")
	public int participationId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name="object_participant_role",
			joinColumns={@JoinColumn(name="participation_id", referencedColumnName="participation_id")},
			inverseJoinColumns={@JoinColumn(name="person_id", referencedColumnName="person_id")})
	private Participant participant; 
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name="object_participant_role",
			joinColumns={@JoinColumn(name="participation_id", referencedColumnName="participation_id")},
			inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")})
	private Role role;

	@Override
	public String toString() {
		return "Participation\n [\nparticipation_id=" + participationId
				+ ",\n participant=" + participant + ",\n role=" + role + "]";
	}

	public int getParticipationId() {
		return participationId;
	}

	public void setParticipationId(int participationId) {
		this.participationId = participationId;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	} 

}
