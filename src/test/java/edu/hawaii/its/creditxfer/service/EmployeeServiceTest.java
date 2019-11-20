package edu.hawaii.its.creditxfer.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
import edu.hawaii.its.creditxfer.type.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
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

    @Test
    public void testEquals() {
        Employee e1 = new Employee();
        assertThat(e1, equalTo(e1));
        Employee e2 = null;
        assertThat(e1, not(equalTo(e2)));
        e2 = new Employee();
        assertThat(e1, equalTo(e2));
        e1.setUhNumber(1L);
        assertThat(e1, not(equalTo(e2)));
        e2.setUhNumber(1L);
        assertThat(e1, equalTo(e2));
        e2.setUhNumber(2L);
        assertThat(e1, not(equalTo(e2)));
        e1.setUhNumber(null);
        e2.setUhNumber(2L);
        assertThat(e1, not(equalTo(e2)));
        // Wrong class.
        assertThat(e1, not(equalTo(new String())));
    }

    @Test
    public void testHashCode() {
        Employee e0 = new Employee();
        Employee e1 = new Employee();
        assertThat(e0, equalTo(e1));
        assertThat(e1, equalTo(e0));
        assertThat(e0.hashCode(), equalTo(e1.hashCode()));
        assertThat(e1.hashCode(), equalTo(e0.hashCode()));
        e0.setUhNumber(1L);
        assertThat(e0, not(equalTo(e1)));
        assertThat(e1, not(equalTo(e0)));
        assertThat(e0.hashCode(), not(equalTo(e1.hashCode())));
        assertThat(e1.hashCode(), not(equalTo(e0.hashCode())));
        e1.setUhNumber(e0.getUhNumber());
        assertThat(e0, equalTo(e1));
        assertThat(e1, equalTo(e0));
        assertThat(e0.hashCode(), equalTo(e1.hashCode()));
        assertThat(e1.hashCode(), equalTo(e0.hashCode()));
        assertThat(e0.equals(e0), equalTo(true));
        assertThat(e0.equals(null), equalTo(false));
        assertThat(e0.equals(new String()), equalTo(false));
    }
}
