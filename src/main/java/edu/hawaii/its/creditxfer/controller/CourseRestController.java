package edu.hawaii.its.creditxfer.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/api/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData<List<Course>>> courses() {
        logger.info("Entered REST courses...");
        List<Course> courses = courseService.findAll();
        JsonData<List<Course>> data = new JsonData<>(courses);
        return ResponseEntity
            .ok()
            .body(data);
    }

    @GetMapping(value = "/api/courses/attribute/{attribute}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData<List<Course>>> coursesByAttribute(@PathVariable String attribute) {
        logger.info("Entered REST courses(" + attribute + ") ...");
        List<Course> courses = courseService.findAllByAttribute(attribute.toUpperCase());
        JsonData<List<Course>> data = new JsonData<>(courses);
        return ResponseEntity
            .ok()
            .body(data);
    }

    @GetMapping(value = "/api/courses/subject/{subject}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData<List<Course>>> coursesBySubject(@PathVariable String subject) {
        logger.info("Entered REST courses(" + subject + ") ...");
        List<Course> courses = courseService.findAllBySubject(subject.toUpperCase());
        JsonData<List<Course>> data = new JsonData<>(courses);
        return ResponseEntity
            .ok()
            .body(data);
    }

    @GetMapping(value = "api/courses/subject/{subject}/number/{courseNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData<List<Course>>> coursesBySubjectAndCourseNumber(
        @PathVariable String subject,
        @PathVariable String courseNumber) {
        logger.info("Entered REST courses(" + subject + " " + courseNumber + ") ...");
        List<Course> courses = courseService.findAllBySubjectAndCourseNumber(subject.toUpperCase(), String.valueOf(courseNumber));
        JsonData<List<Course>> data = new JsonData<>(courses);
        return ResponseEntity
            .ok()
            .body(data);
    }

    @GetMapping(value = "api/courses/mif/{mif}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonData<List<Course>>> coursesByMifValue(@PathVariable String mif) {
        logger.info("Entered REST courses(" + mif + ") ...");
        List<Course> courses = courseService.findAllByMifValue(mif.toUpperCase());
        JsonData<List<Course>> data = new JsonData<>(courses);
        return ResponseEntity
            .ok()
            .body(data);
    }

}
