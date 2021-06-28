package com.accolite.courseManagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Participants {
	
	@Id
    private long id;
	private String name;
	private String email;

	public Participants() {
		
	}

	public Participants(long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email= email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String name) {
		this.name = email;
	}

	
	@Override
	public String toString() {
		return "Participants [ParticipantId=" + id + ", name=" + name + ", email="+ email + "]";
	}

}
