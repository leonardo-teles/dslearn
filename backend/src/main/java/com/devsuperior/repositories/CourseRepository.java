package com.devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
