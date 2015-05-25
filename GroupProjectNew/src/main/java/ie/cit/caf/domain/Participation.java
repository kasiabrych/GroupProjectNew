package ie.cit.caf.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Participation {
	
	@JsonUnwrapped
	Participant participant; 
	@JsonUnwrapped
	Role role;
	
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
	@Override
	public String toString() {
		return "Participation [participant=" + participant + ",\n role=" + role
				+ "]";
	} 

}
