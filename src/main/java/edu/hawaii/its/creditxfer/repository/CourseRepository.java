package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hawaii.its.creditxfer.type.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAll();
}
