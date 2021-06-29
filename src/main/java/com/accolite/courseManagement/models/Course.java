package com.accolite.courseManagement.models;

import java.util.List;

import com.accolite.courseManagement.entities.Creator;
import com.accolite.courseManagement.entities.Skill;

public class Course {
	private Long id;
	private String coursename;
	private String description;
	private String prerequesite;
	private String lastupdated;
	private String feedback;
	private List<Skill> skills;
	private List<Creator> creator;
	private String location;

	public Course() {
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCourseName() {
		return coursename;
	}
	
	public void setCourseName(String coursename) {
		this.coursename = coursename;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPrerequesite() {
		return prerequesite;
	}
	
	public void setPrerequesite(String prerequesite) {
		this.prerequesite = prerequesite;
	}
	
	public String getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(String lastupdated) {
		this.lastupdated = lastupdated;
	}
	
	public String getFeedback() {
		return feedback;
	}
	
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<Skill> getSkills() {
		return skills;
	}
	
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public List<Creator> getCreator() {
		return creator;
	}
	
	public void setCreator(List<Creator> creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", CourseName=" + coursename + ", desc=" + description + ", prerequesite=" + prerequesite + ", lastUpdated="
				+ lastupdated + ", feedback=" + feedback + ", location=" + location + ", skill=" + skills + ", creator=" + creator + "]";
	}
	
//	public String getDetails() {
//		return "Course Details of "+ description +"\nPrerequesite=" + prerequesite + "\nLastUpdated="
//				+ lastupdated + "\nFeedback=" + feedback + "\nLocation=" + location + "\nSkill=" + skills + "\nCreator=" + creator;
//		
//	}

}
