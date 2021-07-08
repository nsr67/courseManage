package com.accolite.courseManagement.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String coursename;
	private String description;
	private String prerequesite;
	private String feedback;
	private String location;
    private String lastupdated;
 
	@ManyToMany(cascade = {
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    },fetch = FetchType.LAZY)
	private List<Skill> skill;
	@ManyToMany(cascade = {
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    },fetch = FetchType.LAZY)
	private List<Creator> creator;
	
	public CourseEntity() {
	}
	
	public CourseEntity(Long id, String coursename, String description, String prerequesite, String feedback,
			String location, String lastupdated, List<Skill> skill, List<Creator> creator) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.description = description;
		this.prerequesite = prerequesite;
		this.feedback = feedback;
		this.location = location;
		this.lastupdated = lastupdated;
		this.skill = skill;
		this.creator = creator;
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

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
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
				+ lastupdated + ", feedback=" + feedback + ", location=" + location + ", skill=" + skill + ", creator=" + creator +"]";
	}

}
