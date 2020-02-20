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
public class SourceCatalogTest {
    
    @Test
    public void testToString() {
        SourceCatalog sourceCatalog = new SourceCatalog();
        String expected = "SourceCatalog [sourceInstitutionCode=null";
        assertThat(sourceCatalog.toString(), containsString(expected));

        sourceCatalog.setSourceInstitutionCode("code");
        sourceCatalog.setMifValue("mif");
        sourceCatalog.setAcademicPeriodStart("000000");
        sourceCatalog.setSubjectCodeTrans("trans");
        sourceCatalog.setCourseNumberTrans("000");
        sourceCatalog.setCourseTitleTrans("title");
        sourceCatalog.setTransCourseActivityDate(Date.valueOf("2020-01-01"));

        assertThat(sourceCatalog.toString(), containsString("SourceCatalog [sourceInstitutionCode=code, " +
            "mifValue=mif, academicPeriodStart=000000"));
    }

    @Test
    public void testEquals() {
        SourceId s1 = new SourceId();
        assertThat(s1, equalTo(s1));
        SourceId s2 = null;
        assertThat(s1, not(equalTo(s2)));
        s2 = new SourceId();
        assertThat(s1, equalTo(s2));
        s1.setSourceInstitutionCode("code");
        assertThat(s1, not(equalTo(s2)));
        s2.setSourceInstitutionCode("code");
        assertThat(s1, equalTo(s2));
        s2.setSourceInstitutionCode("code 2");
        assertThat(s1, not(equalTo(s2)));
        s1.setSourceInstitutionCode(null);
        s2.setSourceInstitutionCode("code 2");
        assertThat(s1, not(equalTo(s2)));
        // Wrong class.
        assertThat(s1, not(equalTo(new String())));
    }

    @Test
    public void testHashCode() {
        SourceId s0 = new SourceId();
        SourceId s1 = new SourceId();
        assertThat(s0, equalTo(s1));
        assertThat(s1, equalTo(s0));
        assertThat(s0.hashCode(), equalTo(s1.hashCode()));
        assertThat(s1.hashCode(), equalTo(s0.hashCode()));
        s0.setSourceInstitutionCode("code");
        assertThat(s0, not(equalTo(s1)));
        assertThat(s1, not(equalTo(s0)));
        assertThat(s0.hashCode(), not(equalTo(s1.hashCode())));
        assertThat(s1.hashCode(), not(equalTo(s0.hashCode())));
        s1.setSourceInstitutionCode(s0.getSourceInstitutionCode());
        assertThat(s0, equalTo(s1));
        assertThat(s1, equalTo(s0));
        assertThat(s0.hashCode(), equalTo(s1.hashCode()));
        assertThat(s1.hashCode(), equalTo(s0.hashCode()));
        s0.setMifValue("mif");
        assertThat(s0, not(equalTo(s1)));
        assertThat(s1, not(equalTo(s0)));
        assertThat(s0.hashCode(), not(equalTo(s1.hashCode())));
        assertThat(s1.hashCode(), not(equalTo(s0.hashCode())));
        s1.setMifValue(s0.getMifValue());
        assertThat(s0, equalTo(s1));
        assertThat(s1, equalTo(s0));
        assertThat(s0.hashCode(), equalTo(s1.hashCode()));
        assertThat(s1.hashCode(), equalTo(s0.hashCode()));
        s0.setAcademicPeriodStart("start");
        assertThat(s0, not(equalTo(s1)));
        assertThat(s1, not(equalTo(s0)));
        assertThat(s0.hashCode(), not(equalTo(s1.hashCode())));
        assertThat(s1.hashCode(), not(equalTo(s0.hashCode())));
        s1.setAcademicPeriodStart(s0.getAcademicPeriodStart());
        assertThat(s0, equalTo(s1));
        assertThat(s1, equalTo(s0));
        assertThat(s0.hashCode(), equalTo(s1.hashCode()));
        assertThat(s1.hashCode(), equalTo(s0.hashCode()));
        s0.setSubjectCodeTrans("subject");
        assertThat(s0, not(equalTo(s1)));
        assertThat(s1, not(equalTo(s0)));
        assertThat(s0.hashCode(), not(equalTo(s1.hashCode())));
        assertThat(s1.hashCode(), not(equalTo(s0.hashCode())));
        s1.setSubjectCodeTrans(s0.getSubjectCodeTrans());
        assertThat(s0, equalTo(s1));
        assertThat(s1, equalTo(s0));
        assertThat(s0.hashCode(), equalTo(s1.hashCode()));
        assertThat(s1.hashCode(), equalTo(s0.hashCode()));
        s0.setCourseNumberTrans("course");
        assertThat(s0, not(equalTo(s1)));
        assertThat(s1, not(equalTo(s0)));
        assertThat(s0.hashCode(), not(equalTo(s1.hashCode())));
        assertThat(s1.hashCode(), not(equalTo(s0.hashCode())));
        s1.setCourseNumberTrans(s0.getCourseNumberTrans());
        assertThat(s0, equalTo(s1));
        assertThat(s1, equalTo(s0));
        assertThat(s0.hashCode(), equalTo(s1.hashCode()));
        assertThat(s1.hashCode(), equalTo(s0.hashCode()));
        assertThat(s0.equals(s0), equalTo(true));
        assertThat(s0.equals(null), equalTo(false));
        assertThat(s0.equals(new String()), equalTo(false));
    }
}
