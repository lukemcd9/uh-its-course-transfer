package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
import edu.hawaii.its.creditxfer.type.Institution;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class InstitutionServiceTest {

    @Autowired
    private InstitutionService institutionService;

    @Test
    public void testConstruction() { assertNotNull(institutionService); }

    @Test
    public void findInstitution() {
        Institution institution = institutionService.findInstitution("0154");

        assertEquals("0154", institution.getCode());
        assertEquals("Ogeechee Technical College", institution.getDescription());
        assertEquals("Statesboro", institution.getCity());
        assertEquals("GA", institution.getStateProvince());
    }

    @Test
    public void findAllInstitutionsByState() {
        List<Institution> institutions = institutionService.findAllInstitutionsByState("HI");

        assertEquals(47, institutions.size());
        assertEquals("U of Hawaii West Oahu", institutions.get(0).getDescription());
        assertEquals("N056", institutions.get(46).getCode());
        assertEquals("Hawaii Medical College", institutions.get(46).getDescription());
        assertEquals("Honolulu", institutions.get(46).getCity());
        assertEquals("HI", institutions.get(46).getStateProvince());

        System.out.println(institutions);
    }
    @Test
    public void testEquals() {
        Institution i1 = new Institution();
        assertThat(i1, equalTo(i1));
        Institution i2 = null;
        assertThat(i1, not(equalTo(i2)));
        i2 = new Institution();
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
        Institution i0 = new Institution();
        Institution i1 = new Institution();
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
        i0.setDescription("description");
        assertThat(i0, not(equalTo(i1)));
        assertThat(i1, not(equalTo(i0)));
        assertThat(i0.hashCode(), not(equalTo(i1.hashCode())));
        assertThat(i1.hashCode(), not(equalTo(i0.hashCode())));
        i1.setDescription(i0.getDescription());
        assertThat(i0, equalTo(i1));
        assertThat(i1, equalTo(i0));
        assertThat(i0.hashCode(), equalTo(i1.hashCode()));
        assertThat(i1.hashCode(), equalTo(i0.hashCode()));
        i0.setCity("city");
        assertThat(i0, not(equalTo(i1)));
        assertThat(i1, not(equalTo(i0)));
        assertThat(i0.hashCode(), not(equalTo(i1.hashCode())));
        assertThat(i1.hashCode(), not(equalTo(i0.hashCode())));
        i1.setCity("city");
        assertThat(i0, equalTo(i1));
        assertThat(i1, equalTo(i0));
        assertThat(i0.hashCode(), equalTo(i1.hashCode()));
        assertThat(i1.hashCode(), equalTo(i0.hashCode()));
        i0.setStateProvince("state");
        assertThat(i0, not(equalTo(i1)));
        assertThat(i1, not(equalTo(i0)));
        assertThat(i0.hashCode(), not(equalTo(i1.hashCode())));
        assertThat(i1.hashCode(), not(equalTo(i0.hashCode())));
        i1.setStateProvince("state");
        assertThat(i0, equalTo(i1));
        assertThat(i1, equalTo(i0));
        assertThat(i0.hashCode(), equalTo(i1.hashCode()));
        assertThat(i1.hashCode(), equalTo(i0.hashCode()));
        assertThat(i0.equals(i0), equalTo(true));
        assertThat(i0.equals(null), equalTo(false));
        assertThat(i0.equals(new String()), equalTo(false));
    }
}
