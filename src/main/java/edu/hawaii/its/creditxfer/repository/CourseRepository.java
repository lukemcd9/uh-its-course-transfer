package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.hawaii.its.creditxfer.type.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAllByOrderBySubject();

    List<Course> findAllByAttribute(String attribute);

    List<Course> findAllBySubject(String subject);

    @Query("select c from Course c where c.subject = :subject and c.courseNumber = :courseNumber")
    List<Course> findAllBySubjectAndCourseNumber(@Param("subject") String subject, @Param("courseNumber") String courseNumber);

    List<Course> findAllByMifValueOrderBySubject(String mifValue);
}
