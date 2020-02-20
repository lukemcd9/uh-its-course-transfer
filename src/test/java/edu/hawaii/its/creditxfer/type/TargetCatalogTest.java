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
public class TargetCatalogTest {

    @Test
    public void testToString() {
        TargetCatalog targetCatalog = new TargetCatalog();
        String expected = "TargetCatalog [sourceInstitutionCode=null";
        assertThat(targetCatalog.toString(), containsString(expected));

        targetCatalog.setSourceInstitutionCode("code");
        targetCatalog.setMifValue("mif");
        targetCatalog.setAcademicPeriodStart("000000");
        targetCatalog.setSubjectCodeTrans("trans");
        targetCatalog.setCourseNumberTrans("000");
        targetCatalog.setSubjectCodeEquiv("equiv");
        targetCatalog.setCourseNumberEquiv("999");
        targetCatalog.setCourseTitleEquiv("title");
        targetCatalog.setEquivCreditsUsed(0);
        targetCatalog.setEquivCourseActivityDate(Date.valueOf("2020-01-01"));
        targetCatalog.setSequenceNumber(0);
        targetCatalog.setConnector("AND");

        assertThat(targetCatalog.toString(), containsString("TargetCatalog [sourceInstitutionCode=code, " +
            "mifValue=mif, academicPeriodStart=000000"));
    }

    @Test
    public void testEquals() {
        TargetId t1 = new TargetId();
        assertThat(t1, equalTo(t1));
        TargetId t2 = null;
        assertThat(t1, not(equalTo(t2)));
        t2 = new TargetId();
        assertThat(t1, equalTo(t2));
        t1.setSourceInstitutionCode("code");
        assertThat(t1, not(equalTo(t2)));
        t2.setSourceInstitutionCode("code");
        assertThat(t1, equalTo(t2));
        t2.setSourceInstitutionCode("code 2");
        assertThat(t1, not(equalTo(t2)));
        t1.setSourceInstitutionCode(null);
        t2.setSourceInstitutionCode("code 2");
        assertThat(t1, not(equalTo(t2)));
        // Wrong class.
        assertThat(t1, not(equalTo(new String())));
    }
    
    @Test
    public void testHashCode() {
        TargetId t0 = new TargetId();
        TargetId t1 = new TargetId();
        assertThat(t0, equalTo(t1));
        assertThat(t1, equalTo(t0));
        assertThat(t0.hashCode(), equalTo(t1.hashCode()));
        assertThat(t1.hashCode(), equalTo(t0.hashCode()));
        t0.setSourceInstitutionCode("code");
        assertThat(t0, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t0)));
        assertThat(t0.hashCode(), not(equalTo(t1.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t0.hashCode())));
        t1.setSourceInstitutionCode(t0.getSourceInstitutionCode());
        assertThat(t0, equalTo(t1));
        assertThat(t1, equalTo(t0));
        assertThat(t0.hashCode(), equalTo(t1.hashCode()));
        assertThat(t1.hashCode(), equalTo(t0.hashCode()));
        t0.setMifValue("mif");
        assertThat(t0, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t0)));
        assertThat(t0.hashCode(), not(equalTo(t1.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t0.hashCode())));
        t1.setMifValue(t0.getMifValue());
        assertThat(t0, equalTo(t1));
        assertThat(t1, equalTo(t0));
        assertThat(t0.hashCode(), equalTo(t1.hashCode()));
        assertThat(t1.hashCode(), equalTo(t0.hashCode()));
        t0.setAcademicPeriodStart("start");
        assertThat(t0, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t0)));
        assertThat(t0.hashCode(), not(equalTo(t1.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t0.hashCode())));
        t1.setAcademicPeriodStart(t0.getAcademicPeriodStart());
        assertThat(t0, equalTo(t1));
        assertThat(t1, equalTo(t0));
        assertThat(t0.hashCode(), equalTo(t1.hashCode()));
        assertThat(t1.hashCode(), equalTo(t0.hashCode()));
        t0.setSubjectCodeTrans("subject");
        assertThat(t0, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t0)));
        assertThat(t0.hashCode(), not(equalTo(t1.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t0.hashCode())));
        t1.setSubjectCodeTrans(t0.getSubjectCodeTrans());
        assertThat(t0, equalTo(t1));
        assertThat(t1, equalTo(t0));
        assertThat(t0.hashCode(), equalTo(t1.hashCode()));
        assertThat(t1.hashCode(), equalTo(t0.hashCode()));
        t0.setCourseNumberTrans("course");
        assertThat(t0, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t0)));
        assertThat(t0.hashCode(), not(equalTo(t1.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t0.hashCode())));
        t1.setCourseNumberTrans(t0.getCourseNumberTrans());
        assertThat(t0, equalTo(t1));
        assertThat(t1, equalTo(t0));
        assertThat(t0.hashCode(), equalTo(t1.hashCode()));
        assertThat(t1.hashCode(), equalTo(t0.hashCode()));
        t0.setSequenceNumber(9);
        assertThat(t0, not(equalTo(t1)));
        assertThat(t1, not(equalTo(t0)));
        assertThat(t0.hashCode(), not(equalTo(t1.hashCode())));
        assertThat(t1.hashCode(), not(equalTo(t0.hashCode())));
        t1.setSequenceNumber(t0.getSequenceNumber());
        assertThat(t0, equalTo(t1));
        assertThat(t1, equalTo(t0));
        assertThat(t0.hashCode(), equalTo(t1.hashCode()));
        assertThat(t1.hashCode(), equalTo(t0.hashCode()));
        assertThat(t0.equals(t0), equalTo(true));
        assertThat(t0.equals(null), equalTo(false));
        assertThat(t0.equals(new String()), equalTo(false));
    }
}
