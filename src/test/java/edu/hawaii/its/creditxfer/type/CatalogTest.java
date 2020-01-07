package edu.hawaii.its.creditxfer.type;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class CatalogTest {

    @Test
    public void testToString() {
        Catalog catalog = new Catalog();
        String expected = "Catalog [mifValue=null,";
        assertThat(catalog.toString(), containsString(expected));

        catalog.setMifValue("mif");
        catalog.setSourceInstitutionCode("sourceInst");
        catalog.setCourseIdTrans("transId");
        catalog.setSubjectCodeTrans("transSubject");
        catalog.setCourseNumberTrans("transNumber");
        catalog.setCourseTitleTrans("transTitle");
        catalog.setCourseLowHoursTrans(0);
        catalog.setCourseHighHoursTrans(0);
        catalog.setReviewInd("review");
        catalog.setTastCode("tast");
        catalog.setTransMinGradeCode("transMinGradeCode");
        catalog.setTransGroupConnector("transGroupConnector");
        catalog.setAcademicPeriodStart("academicPeriodStart");
        catalog.setTransCourseActivityDate(Date.valueOf("2019-01-30"));
        catalog.setSequenceNumber(0);
        catalog.setEquivLeftParen("(");
        catalog.setConnector("connector");
        catalog.setCourseIdEquiv("equivId");
        catalog.setSubjectCodeEquiv("equivSubject");
        catalog.setCourseNumberEquiv("equivNumber");
        catalog.setCourseTitleEquiv("equivTitle");
        catalog.setEquivCreditsUsed(0);
        catalog.setEquivRightParen(")");
        catalog.setEquivCourseActivityDate(Date.valueOf("2019-01-30"));

        expected = "Catalog [mifValue=mif, sourceInstitutionCode=sourceInst, ";
        assertThat(catalog.toString(), containsString(expected));
    }
}
