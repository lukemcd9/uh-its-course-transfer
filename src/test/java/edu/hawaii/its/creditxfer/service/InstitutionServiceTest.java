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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
}
