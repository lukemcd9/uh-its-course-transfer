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
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void exists() {
        assertTrue(employeeService.exists("89999999"));
        assertTrue(employeeService.exists("10000004"));

        assertFalse(employeeService.exists(null));
        assertFalse(employeeService.exists(""));
        assertFalse(employeeService.exists("  "));
        assertFalse(employeeService.exists("no-way-none"));
        assertFalse(employeeService.exists("99999999"));
    }
}
