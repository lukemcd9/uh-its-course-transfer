package edu.hawaii.its.creditxfer.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.hawaii.its.creditxfer.service.CourseService;
import edu.hawaii.its.creditxfer.type.Course;

@RestController
public class CourseRestController {

    private static final Log logger = LogFactory.getLog(InstitutionRestController.class);

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/api/courses")
    public ResponseEntity<List<Course>> courses() {
        logger.info("Entered REST courses...");
        List<Course> courses = courseService.findAll();
        return ResponseEntity
            .ok()
            .body(courses);
    }

    @GetMapping(value = "api/courses/source/{source}/target/{target}/subject/{subject}")
    public ResponseEntity<List<Course>> courseBySourceTargetAndSubject(
        @PathVariable String source,
        @PathVariable String target,
        @PathVariable String subject) {
        logger.info("Entered REST courses(" + source + ", " + subject + ", " + target + ")...");
        List<Course> courses = courseService.findBySourceTargetAndSubject(String.valueOf(source), target.toUpperCase(), subject.toUpperCase(), "WI");
        return ResponseEntity
            .ok()
            .body(courses);
    }
}
