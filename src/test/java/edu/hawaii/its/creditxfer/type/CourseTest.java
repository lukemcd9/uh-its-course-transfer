package edu.hawaii.its.creditxfer.type;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class CourseTest {

    @Test
    public void testToString() {
        Course course = new Course();
        String expected = "Course [attribute=null,";
        assertThat(course.toString(), containsString(expected));

        course.setAttribute("dh");
        course.setStart("start");
        course.setStartDescription("start desc");
        course.setEnd("end");
        course.setEndDescription("end desc");
        course.setMifValue("haw");
        course.setSubject("ics");
        course.setCourseNumber("111");

        expected = "Course [attribute=dh, start=start, startDescription=start desc,";
        assertThat(course.toString(), containsString(expected));
    }
}
