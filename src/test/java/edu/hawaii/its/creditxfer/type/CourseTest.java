package edu.hawaii.its.creditxfer.type;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class CourseTest {

    @Test
    public void testToString() {
        Course course = new Course();
        String expected = "Course [sourceInstitutionCode=null";
        assertThat(course.toString(), containsString(expected));

        course.setSourceInstitutionCode("code");
        course.setMifValue("mif");
        course.setAcademicPeriodStart("000000");
        course.setSubjectCodeTrans("trans");
        course.setCourseNumberTrans("000");
        course.setSubjectCodeEquiv("equiv");
        course.setCourseNumberEquiv("999");
        course.setEquivCourseAttribute("FS");
        course.setEquivCourseAttributeDesc("desc");
        course.setEquivAttrActivityDate(Date.valueOf("2020-01-01"));

        assertThat(course.toString(), containsString("Course [sourceInstitutionCode=code, " +
            "mifValue=mif, academicPeriodStart=000000"));
    }

    @Test
    public void testEquals() {
        CourseId c1 = new CourseId();
        assertThat(c1, equalTo(c1));
        CourseId c2 = null;
        assertThat(c1, not(equalTo(c2)));
        c2 = new CourseId();
        assertThat(c1, equalTo(c2));
        c1.setSourceInstitutionCode("code");
        assertThat(c1, not(equalTo(c2)));
        c2.setSourceInstitutionCode("code");
        assertThat(c1, equalTo(c2));
        c2.setSourceInstitutionCode("code 2");
        assertThat(c1, not(equalTo(c2)));
        c1.setSourceInstitutionCode(null);
        c2.setSourceInstitutionCode("code 2");
        assertThat(c1, not(equalTo(c2)));
        // Wrong class.
        assertThat(c1, not(equalTo(new String())));
    }


    @Test
    public void testHashCode() {
        CourseId c0 = new CourseId();
        CourseId c1 = new CourseId();
        assertThat(c0, equalTo(c1));
        assertThat(c1, equalTo(c0));
        assertThat(c0.hashCode(), equalTo(c1.hashCode()));
        assertThat(c1.hashCode(), equalTo(c0.hashCode()));
        c0.setSourceInstitutionCode("code");
        assertThat(c0, not(equalTo(c1)));
        assertThat(c1, not(equalTo(c0)));
        assertThat(c0.hashCode(), not(equalTo(c1.hashCode())));
        assertThat(c1.hashCode(), not(equalTo(c0.hashCode())));
        c1.setSourceInstitutionCode(c0.getSourceInstitutionCode());
        assertThat(c0, equalTo(c1));
        assertThat(c1, equalTo(c0));
        assertThat(c0.hashCode(), equalTo(c1.hashCode()));
        assertThat(c1.hashCode(), equalTo(c0.hashCode()));
        c0.setMifValue("mif");
        assertThat(c0, not(equalTo(c1)));
        assertThat(c1, not(equalTo(c0)));
        assertThat(c0.hashCode(), not(equalTo(c1.hashCode())));
        assertThat(c1.hashCode(), not(equalTo(c0.hashCode())));
        c1.setMifValue(c0.getMifValue());
        assertThat(c0, equalTo(c1));
        assertThat(c1, equalTo(c0));
        assertThat(c0.hashCode(), equalTo(c1.hashCode()));
        assertThat(c1.hashCode(), equalTo(c0.hashCode()));
        c0.setAcademicPeriodStart("start");
        assertThat(c0, not(equalTo(c1)));
        assertThat(c1, not(equalTo(c0)));
        assertThat(c0.hashCode(), not(equalTo(c1.hashCode())));
        assertThat(c1.hashCode(), not(equalTo(c0.hashCode())));
        c1.setAcademicPeriodStart(c0.getAcademicPeriodStart());
        assertThat(c0, equalTo(c1));
        assertThat(c1, equalTo(c0));
        assertThat(c0.hashCode(), equalTo(c1.hashCode()));
        assertThat(c1.hashCode(), equalTo(c0.hashCode()));
        c0.setSubjectCodeTrans("subject");
        assertThat(c0, not(equalTo(c1)));
        assertThat(c1, not(equalTo(c0)));
        assertThat(c0.hashCode(), not(equalTo(c1.hashCode())));
        assertThat(c1.hashCode(), not(equalTo(c0.hashCode())));
        c1.setSubjectCodeTrans(c0.getSubjectCodeTrans());
        assertThat(c0, equalTo(c1));
        assertThat(c1, equalTo(c0));
        assertThat(c0.hashCode(), equalTo(c1.hashCode()));
        assertThat(c1.hashCode(), equalTo(c0.hashCode()));
        c0.setCourseNumberTrans("course");
        assertThat(c0, not(equalTo(c1)));
        assertThat(c1, not(equalTo(c0)));
        assertThat(c0.hashCode(), not(equalTo(c1.hashCode())));
        assertThat(c1.hashCode(), not(equalTo(c0.hashCode())));
        c1.setCourseNumberTrans(c0.getCourseNumberTrans());
        assertThat(c0, equalTo(c1));
        assertThat(c1, equalTo(c0));
        assertThat(c0.hashCode(), equalTo(c1.hashCode()));
        assertThat(c1.hashCode(), equalTo(c0.hashCode()));
        c0.setSubjectCodeEquiv("equivSubj");
        assertThat(c0, not(equalTo(c1)));
        assertThat(c1, not(equalTo(c0)));
        assertThat(c0.hashCode(), not(equalTo(c1.hashCode())));
        assertThat(c1.hashCode(), not(equalTo(c0.hashCode())));
        c1.setSubjectCodeEquiv(c0.getSubjectCodeEquiv());
        assertThat(c0, equalTo(c1));
        assertThat(c1, equalTo(c0));
        assertThat(c0.hashCode(), equalTo(c1.hashCode()));
        assertThat(c1.hashCode(), equalTo(c0.hashCode()));
        c0.setCourseNumberEquiv("equivCourse");
        assertThat(c0, not(equalTo(c1)));
        assertThat(c1, not(equalTo(c0)));
        assertThat(c0.hashCode(), not(equalTo(c1.hashCode())));
        assertThat(c1.hashCode(), not(equalTo(c0.hashCode())));
        c1.setCourseNumberEquiv(c0.getCourseNumberEquiv());
        assertThat(c0, equalTo(c1));
        assertThat(c1, equalTo(c0));
        assertThat(c0.hashCode(), equalTo(c1.hashCode()));
        assertThat(c1.hashCode(), equalTo(c0.hashCode()));
        c0.setEquivCourseAttribute("attr");
        assertThat(c0, not(equalTo(c1)));
        assertThat(c1, not(equalTo(c0)));
        assertThat(c0.hashCode(), not(equalTo(c1.hashCode())));
        assertThat(c1.hashCode(), not(equalTo(c0.hashCode())));
        c1.setEquivCourseAttribute(c0.getEquivCourseAttribute());
        assertThat(c0, equalTo(c1));
        assertThat(c1, equalTo(c0));
        assertThat(c0.hashCode(), equalTo(c1.hashCode()));
        assertThat(c1.hashCode(), equalTo(c0.hashCode()));
        assertThat(c0.equals(c0), equalTo(true));
        assertThat(c0.equals(null), equalTo(false));
        assertThat(c0.equals(new String()), equalTo(false));
    }

}
