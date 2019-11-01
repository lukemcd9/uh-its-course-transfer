package edu.hawaii.its.creditxfer.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hawaii.its.creditxfer.service.CourseService;
import edu.hawaii.its.creditxfer.type.Course;

@RestController
public class CourseRestController {

    private static final Log logger = LogFactory.getLog(InstitutionRestController.class);

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/api/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData<List<Course>>> courses() {
        logger.info("Entered REST courses...");
        List<Course> courses = courseService.findAll();
        logger.info(courses.size() + " results.");
        JsonData<List<Course>> data = new JsonData<>(courses);
        return ResponseEntity
            .ok()
            .body(data);
    }
}
