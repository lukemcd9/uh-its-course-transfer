package edu.hawaii.its.creditxfer.type;

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
public class InstitutionTest {

    @Test
    public void testToString() {
        Institution institution = new Institution();
        String expected = "Institution [code=null,";
        assertThat(institution.toString(), containsString(expected));

        institution.setCode("12345");
        institution.setDescription("big institution");
        institution.setCity("big city");
        institution.setStateProvince("NO");
        institution.setMifValue("MAN");
        institution.setMifDescription("MANOA");
        institution.setAcademicPeriodStart("000000");
        assertThat(institution.toString(), containsString("Institution [code=12345, description=big institution, " +
            "city=big city, stateProvince=NO, mifValue=MAN, mifDesc=MANOA, academicPeriodStart=000000]"));
    }

    @Test
    public void testEquals() {
        InstitutionId i1 = new InstitutionId();
        assertThat(i1, equalTo(i1));
        InstitutionId i2 = null;
        assertThat(i1, not(equalTo(i2)));
        i2 = new InstitutionId();
        assertThat(i1, equalTo(i2));
        i1.setCode("code");
        assertThat(i1, not(equalTo(i2)));
        i2.setCode("code");
        assertThat(i1, equalTo(i2));
        i2.setCode("code 2");
        assertThat(i1, not(equalTo(i2)));
        i1.setCode(null);
        i2.setCode("code 2");
        assertThat(i1, not(equalTo(i2)));
        // Wrong class.
        assertThat(i1, not(equalTo(new String())));
    }

    @Test
    public void testHashCode() {
        InstitutionId i0 = new InstitutionId();
        InstitutionId i1 = new InstitutionId();
        assertThat(i0, equalTo(i1));
        assertThat(i1, equalTo(i0));
        assertThat(i0.hashCode(), equalTo(i1.hashCode()));
        assertThat(i1.hashCode(), equalTo(i0.hashCode()));
        i0.setCode("code");
        assertThat(i0, not(equalTo(i1)));
        assertThat(i1, not(equalTo(i0)));
        assertThat(i0.hashCode(), not(equalTo(i1.hashCode())));
        assertThat(i1.hashCode(), not(equalTo(i0.hashCode())));
        i1.setCode(i0.getCode());
        assertThat(i0, equalTo(i1));
        assertThat(i1, equalTo(i0));
        assertThat(i0.hashCode(), equalTo(i1.hashCode()));
        assertThat(i1.hashCode(), equalTo(i0.hashCode()));
        i0.setMifValue("mif");
        assertThat(i0, not(equalTo(i1)));
        assertThat(i1, not(equalTo(i0)));
        assertThat(i0.hashCode(), not(equalTo(i1.hashCode())));
        assertThat(i1.hashCode(), not(equalTo(i0.hashCode())));
        i1.setMifValue(i0.getMifValue());
        assertThat(i0, equalTo(i1));
        assertThat(i1, equalTo(i0));
        assertThat(i0.hashCode(), equalTo(i1.hashCode()));
        assertThat(i1.hashCode(), equalTo(i0.hashCode()));
        i0.setAcademicPeriodStart("start");
        assertThat(i0, not(equalTo(i1)));
        assertThat(i1, not(equalTo(i0)));
        assertThat(i0.hashCode(), not(equalTo(i1.hashCode())));
        assertThat(i1.hashCode(), not(equalTo(i0.hashCode())));
        i1.setAcademicPeriodStart(i0.getAcademicPeriodStart());
        assertThat(i0, equalTo(i1));
        assertThat(i1, equalTo(i0));
        assertThat(i0.hashCode(), equalTo(i1.hashCode()));
        assertThat(i1.hashCode(), equalTo(i0.hashCode()));
        assertThat(i0.equals(i0), equalTo(true));
        assertThat(i0.equals(null), equalTo(false));
        assertThat(i0.equals(new String()), equalTo(false));
    }
}
