package com.accolite.courseManagement.models;



public class Participants {
	
	private String email;
	private String subject;
	private String body;

	public Participants() {
		
	}
	
	public Participants(String email, String subject, String body) {
		super();
		this.email = email;
		this.subject = subject;
		this.body = body;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	@Override
	public String toString() {
		return "Participants [Email Address=" + email + ", Subject=" + subject + ", Body="+ body + "]";
	}

}
