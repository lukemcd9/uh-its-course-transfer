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
public class EmployeeTest {

    @Test
    public void employeeConstruction() {
        Employee employee = new Employee(1L);
        assertNotNull(employee);
        assertEquals(employee.getUhNumber(), Long.valueOf(1L));
    }

    @Test
    public void testToString() {
        Employee employee = new Employee();
        String expected = "Employee [uhNumber=null]";
        assertThat(employee.toString(), containsString(expected));

        employee.setUhNumber(1L);
        assertThat(employee.toString(), containsString("Employee [uhNumber=1]"));
    }
}
