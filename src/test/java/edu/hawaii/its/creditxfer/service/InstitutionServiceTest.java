package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
import edu.hawaii.its.creditxfer.type.Institution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class InstitutionServiceTest {

    @Autowired
    private InstitutionService institutionService;

    @Test
    public void testConstruction() { assertNotNull(institutionService); }

    @Test
    public void findInstitutionByCode() {
        List<Institution> institutions = institutionService.findInstitution("4867");
        assertEquals(11, institutions.size());
        assertEquals("4867", institutions.get(0).getCode());
        assertEquals("U of Hawaii Manoa", institutions.get(0).getDescription());
        assertEquals("Honolulu", institutions.get(0).getCity());
        assertEquals("HI", institutions.get(0).getStateProvince());
    }

    @Test
    public void findAllInstitutionsByState() {
        List<Institution> institutions = institutionService.findAllInstitutionsByState("HI");
        assertEquals(160, institutions.size());;
    }
}
