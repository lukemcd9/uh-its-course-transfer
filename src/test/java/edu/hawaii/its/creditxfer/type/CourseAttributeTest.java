package edu.hawaii.its.creditxfer.type;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class CourseAttributeTest {

    @Test
    public void testCourseAttribute() {
        Term t1 = new Term("202010", "Fall 2019");
        Term t2 = new Term("202020", "Winter 2019");
        Term t3 = new Term("202030", "Spring 2020");

        CourseAttributeAssignment a1 = new CourseAttributeAssignment(CourseAttribute.DA, t1, t2);
        CourseAttributeAssignment a2 = new CourseAttributeAssignment(CourseAttribute.DH, t1, t2);
        CourseAttributeAssignment a3 = new CourseAttributeAssignment(CourseAttribute.DB, t1, t3);
        CourseAttributeAssignment a4 = new CourseAttributeAssignment(CourseAttribute.DL, t2, t3);

        assertEquals(CourseAttribute.DA, a1.getAttribute());
        assertEquals(t1, a1.getEffectiveTerm());
        assertEquals(t2, a1.getEndTerm());

        assertEquals(0, a1.compareTo(a1));
        assertEquals(-7, a1.compareTo(a2));
        assertEquals(1, a1.compareTo(a3));
        assertEquals(1, a3.compareTo(a4));


        assertEquals("CourseAttributeAssignment [attribute: DA]", a1.toString());
    }
}
