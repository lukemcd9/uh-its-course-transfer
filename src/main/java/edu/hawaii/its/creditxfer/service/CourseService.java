package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hawaii.its.creditxfer.repository.CourseRepository;
import edu.hawaii.its.creditxfer.type.Course;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAllByOrderBySubjectCodeTrans();
    }

    public List<Course> findBySourceTargetAndSubject(String sourceInstitutionCode, String mifValue, String subject, String attribute) {
        return courseRepository.findBySourceTargetAndSubject(sourceInstitutionCode, mifValue, subject, attribute);
    }
}
