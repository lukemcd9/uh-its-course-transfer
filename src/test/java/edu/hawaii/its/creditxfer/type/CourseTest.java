package edu.hawaii.its.creditxfer.type;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
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
