package com.accolite.courseManagement.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.accolite.courseManagement.entities.CourseEntity;



@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Long> {

//	Optional<CourseEntity> findByLocation(String location);

	
}
