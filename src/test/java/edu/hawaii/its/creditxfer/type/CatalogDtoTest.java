package edu.hawaii.its.creditxfer.type;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class CatalogDtoTest {

    @Test
    public void testConstructor() {
        CatalogDto catalogDto = new CatalogDto("code", "mif", "start",
            "subj", "course", "title", "subj",
            "course", "title", 0, 0, "and");
        assertNotNull(catalogDto);
        assertEquals("code", catalogDto.getSourceInstitutionCode());
        assertEquals("mif", catalogDto.getMifValue());
        assertEquals("start", catalogDto.getAcademicPeriodStart());
        assertEquals("subj", catalogDto.getSubjectCodeTrans());
        assertEquals("course", catalogDto.getCourseNumberTrans());
        assertEquals("title", catalogDto.getCourseTitleTrans());
        assertEquals("subj", catalogDto.getSubjectCodeEquiv());
        assertEquals("course", catalogDto.getCourseNumberEquiv());
        assertEquals("title", catalogDto.getCourseTitleEquiv());
        assertEquals(Integer.valueOf(0), catalogDto.getEquivCreditsUsed());
        assertEquals(Integer.valueOf(0), catalogDto.getSequenceNumber());
        assertEquals("and", catalogDto.getConnector());

    }

    @Test
    public void testToString() {
        CatalogDto catalogDto = new CatalogDto();
        String expected = "CatalogDto [sourceInstitutionCode=null";
        assertThat(catalogDto.toString(), containsString(expected));

        catalogDto.setSourceInstitutionCode("code");
        catalogDto.setMifValue("mif");
        catalogDto.setAcademicPeriodStart("start");
        catalogDto.setSubjectCodeTrans("subj");
        catalogDto.setCourseNumberTrans("course");
        catalogDto.setCourseTitleTrans("title");
        catalogDto.setSubjectCodeEquiv("subj");
        catalogDto.setCourseNumberEquiv("course");
        catalogDto.setCourseTitleEquiv("title");
        catalogDto.setEquivCreditsUsed(0);
        catalogDto.setSequenceNumber(0);
        catalogDto.setConnector("connector");

        assertThat(catalogDto.toString(), containsString("CatalogDto [sourceInstitutionCode=code, " +
            "mifValue=mif, academicPeriodStart=start, "));
    }
}
