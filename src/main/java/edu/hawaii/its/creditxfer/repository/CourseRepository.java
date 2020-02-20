package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.hawaii.its.creditxfer.type.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAllByOrderBySubjectCodeTrans();

    @Query("select c from Course c where c.sourceInstitutionCode = :sourceInstitutionCode and c.mifValue = :mifValue " +
            "and c.subjectCodeTrans = :subject and c.equivCourseAttribute <> :attribute")
    List<Course> findBySourceTargetAndSubject(
            @Param("sourceInstitutionCode") String sourceInstitutionCode,
            @Param("mifValue") String mifValue,
            @Param("subject") String subject,
            @Param("attribute") String attribute);
}
