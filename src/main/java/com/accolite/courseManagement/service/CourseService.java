package com.accolite.courseManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.accolite.courseManagement.entities.CourseEntity;
import com.accolite.courseManagement.entities.Creator;
import com.accolite.courseManagement.entities.Skill;
import com.accolite.courseManagement.exception.NoContentException;
import com.accolite.courseManagement.models.Course;
import com.accolite.courseManagement.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
//	@Autowired
//	private SkillRepository skillRepository;
//	
//	@Autowired
//	private CreatorRepository creatorRepository;

	public Course saveIntocourseItemTable(Course course) {
		CourseEntity entity = courseRepository.save(mapObjectToEntity(course));
		return mapEntityToObject(entity);
	}

	public CourseEntity mapObjectToEntity(Course course) {
		CourseEntity entity = new CourseEntity();
		entity.setId(course.getId());
		entity.setCourseName(course.getCourseName());
		entity.setDescription(course.getDescription());
		entity.setPrerequesite(course.getPrerequesite());
		entity.setLastupdated(course.getLastupdated());
		entity.setFeedback(course.getFeedback());
		entity.setLocation(course.getLocation());
		entity.setSkill(addSkill(course));
		entity.setCreator(addCreator(course));
		return entity;
	}

	private List<Skill> addSkill(Course course) {
		List<Skill> skillList = new ArrayList<>();
		int n = course.getSkill().size();
		System.out.println(n);
		long skillId = 0;
		String name = null;
		for (int i = 0; i < n; i++) {
			skillId = course.getSkill().get(i).getId();
			name = course.getSkill().get(i).getName();
			Skill skill = new Skill(name);
			skillList.add(skill);
		}
		return skillList;
	}
	private List<Creator> addCreator(Course course) {
		List<Creator> creatorList = new ArrayList<>();
		int n = course.getCreator().size();
		long creatorId = 0;
		String name = null;
		for (int i = 0; i < n; i++) {
			creatorId = course.getCreator().get(i).getId();
			name = course.getCreator().get(i).getName();
			Creator creator = new Creator(name);
			creatorList.add(creator);
		}
		return creatorList;
	}

	private List<Skill> addSkill(CourseEntity course) {
		List<Skill> skillList = new ArrayList<>();
		int n = course.getSkill().size();
		long skillId = 0;
		String name = null;
		for (int i = 0; i < n; i++) {
			skillId = course.getSkill().get(i).getId();
			name = course.getSkill().get(i).getName();
			Skill skill = new Skill(skillId, name);
			skillList.add(skill);
		}
		return skillList;
	}


	private List<Creator> addCreator(CourseEntity course) {	
		List<Creator> creatorList = new ArrayList<>();
		int n = course.getCreator().size();
		long creatorId = 0;
		String name = null;
		for (int i = 0; i < n; i++) {
			creatorId = course.getCreator().get(i).getId();
			name = course.getCreator().get(i).getName();
			Creator creator = new Creator(creatorId, name);
			creatorList.add(creator);
		}
		return creatorList;
	}
	public Course mapEntityToObject(CourseEntity entity) {
		Course course = new Course();
		course.setId(entity.getId());
		course.setCourseName(entity.getCourseName());
		course.setDescription(entity.getDescription());
		course.setPrerequesite(entity.getPrerequesite());
		course.setLastupdated(entity.getLastupdated());
		course.setFeedback(entity.getFeedback());
		course.setSkill(addSkill(entity));
		course.setCreator(addCreator(entity));
		course.setLocation(entity.getLocation());
		return course;
	}
	
	public List<CourseEntity> getCourses(){
		return courseRepository.findAll();
	}

	public Course getDataFromcourseTable(Long id) throws NoContentException {
		Optional<CourseEntity> entity = courseRepository.findById(id);
		if (!entity.isPresent()) {
			throw new NoContentException(HttpStatus.NO_CONTENT);
		}
		return mapEntityToObject(entity.get());
	}

	public Course updateDataIntocourseTable(Course course) {
		CourseEntity entity = courseRepository.save(mapObjectToEntity(course));
		return mapEntityToObject(entity);

	}
	
	public List<CourseEntity> getCoursesByLocation(String location) throws NoContentException {

		return courseRepository.findByLocation(location);

	}
}