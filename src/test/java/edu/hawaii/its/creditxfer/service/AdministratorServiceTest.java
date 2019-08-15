package edu.hawaii.its.creditxfer.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class AdministratorServiceTest {

    @Autowired
    private AdministratorService administratorService;

    @Test
    public void exists() {
        assertTrue(administratorService.exists("89999999"));
        assertTrue(administratorService.exists("10000001"));

        assertFalse(administratorService.exists("10000008"));
        assertFalse(administratorService.exists(null));
        assertFalse(administratorService.exists(""));
        assertFalse(administratorService.exists("  "));
        assertFalse(administratorService.exists("no-way-none"));

        //testEmptyAdmin
        administratorService.getAdmins().clear();
        assertFalse(administratorService.exists("89999999"));
        assertFalse(administratorService.exists("10000001"));

        //testNullAdmin
        administratorService.setAdmins(null);
        assertFalse(administratorService.exists("89999999"));
        assertFalse(administratorService.exists("10000001"));

    }

    @Test
    public void testBrokenConfig() {
        AdministratorService administratorService = new AdministratorServiceImpl();

        assertFalse(administratorService.exists("10000001"));
        assertFalse(administratorService.exists("10000002"));

        assertFalse(administratorService.exists(null));
        assertFalse(administratorService.exists(""));
        assertFalse(administratorService.exists("  "));
        assertFalse(administratorService.exists("no-way-none"));
    }

}
