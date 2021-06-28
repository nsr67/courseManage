package com.accolite.courseManagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.accolite.courseManagement.entities.CourseEntity;



@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Long> {

	List<CourseEntity> findByLocation(String location);

	
}
