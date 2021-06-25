package com.accolite.courseManagement.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.courseManagement.entities.CourseEntity;
import com.accolite.courseManagement.exception.NoContentException;
import com.accolite.courseManagement.models.Course;
import com.accolite.courseManagement.repositories.CourseRepository;
import com.accolite.courseManagement.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseRepository courseRepository;

	//save records in course_entity table
	@PostMapping("/save")
	public ResponseEntity<Course> saveIntocourseItemTable(@RequestBody Course course) {
		return new ResponseEntity<>(courseService.saveIntocourseItemTable(course), HttpStatus.OK);
	}

	//Get records from course_enitiy table
	@GetMapping(path = "{id}")
	public ResponseEntity<Course> getDataFromcourseTable(@PathVariable("id") Long id) {
		Course courseData = null;
		try {
			courseData = courseService.getDataFromcourseTable(id);
		} catch (NoContentException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(courseData, HttpStatus.OK);

	}

	//Update records form course_entity table
	@PutMapping("/updatecourse/{id}")
	public ResponseEntity<Course> updatecourse(@PathVariable("id") Long id, @RequestBody Course course) {

		Optional<CourseEntity> courseData = courseRepository.findById(id);

		if (courseData.isPresent()) {

			return new ResponseEntity<>(courseService.updateDataIntocourseTable(course), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Delete records in course_entity table
	@DeleteMapping("/deletecourse/{id}")
	public ResponseEntity<String> deletecourse(@PathVariable("id") Long id) {
		try {

			courseRepository.deleteById(id);
			return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>("Error occured", HttpStatus.EXPECTATION_FAILED);
		}
	}

}
