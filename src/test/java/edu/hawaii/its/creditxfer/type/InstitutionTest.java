package edu.hawaii.its.creditxfer.type;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

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
        assertThat(institution.toString(), containsString("Institution [code=12345, description=big institution, " +
            "city=big city, stateProvince=NO]"));
    }
}
