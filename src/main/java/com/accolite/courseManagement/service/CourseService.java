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
import com.accolite.courseManagement.repositories.CreatorRepository;
import com.accolite.courseManagement.repositories.SkillRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private CreatorRepository creatorRepository;

	public Course saveIntocourseItemTable(Course course) {
		CourseEntity entity = courseRepository.save(mapObjectToEntity(course));
		return mapEntityToObject(entity);
	}

	public CourseEntity mapObjectToEntity(Course course) {
		CourseEntity entity = new CourseEntity();
		entity.setId(course.getId());
		entity.setDescription(course.getDescription());
		entity.setPrerequesite(course.getPrerequesite());
		entity.setLastupdated(course.getLastupdated());
		entity.setFeedback(course.getFeedback());
		entity.setSkill(addSkill(course));
		entity.setCreator(addCreator(course));
		entity.setLocation(course.getLocation());
		return entity;
	}

	private List<Skill> addSkill(Course course) {
		List<Skill> skillList = new ArrayList<>();
		int n = course.getSkills().size();
		long skillId = 0;
		String name = null;
		for (int i = 0; i < n; i++) {
			skillId = course.getSkills().get(i).getId();
			name = course.getSkills().get(i).getName();
			Skill skill = new Skill(skillId, name);
			skillList.add(skill);
		}
		return skillList;
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

	private List<Creator> addCreator(Course course) {
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
		course.setDescription(entity.getDescription());
		course.setPrerequesite(entity.getPrerequesite());
		course.setLastupdated(entity.getLastupdated());
		course.setFeedback(entity.getFeedback());
		course.setSkills(addSkill(entity));
		course.setCreator(addCreator(entity));
		course.setLocation(entity.getLocation());
		return course;
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

//	public Course fetchCoursesByLocation(String location) throws NoContentException {
//
//		Optional<CourseEntity> entity = courseRepository.findByLocation(location);
//		if (!entity.isPresent()) {
//			throw new NoContentException(HttpStatus.NO_CONTENT);
//		}
//		return mapEntityToObject(entity.get());
//
//	}
}