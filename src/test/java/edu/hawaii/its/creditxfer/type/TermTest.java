package edu.hawaii.its.creditxfer.type;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class TermTest {

    @Test
    public void termConstruction() {
        Term term = new Term("000000", "new term");
        assertEquals("000000", term.getTermCode());
        assertEquals("\u221e", term.getTermDescription());
        assertEquals("\u221e", term.getShortName());

        term = new Term("999999", "new term");
        assertEquals("999999", term.getTermCode());
        assertEquals("present", term.getTermDescription());
        assertEquals("present", term.getShortName());

        term = new Term("202000", "All Year");
        assertEquals("202000", term.getTermCode());
        assertEquals("All Year", term.getTermDescription());
        assertEquals("2019", term.getShortName());

        term = new Term("202010", "Fall 2019");
        assertEquals("202010", term.getTermCode());
        assertEquals("Fall 2019", term.getTermDescription());
        assertEquals("F/2019", term.getShortName());

        term = new Term("202020", "Winter 2019");
        assertEquals("202020", term.getTermCode());
        assertEquals("Winter 2019", term.getTermDescription());
        assertEquals("W/2019", term.getShortName());

        term = new Term("202030", "Spring 2020");
        assertEquals("202030", term.getTermCode());
        assertEquals("Spring 2020", term.getTermDescription());
        assertEquals("Sp/2020", term.getShortName());

        term = new Term("202045", "Summer 2020 Accelerated");
        assertEquals("202045", term.getTermCode());
        assertEquals("Summer 2020 Accelerated", term.getTermDescription());
        assertEquals("Su/2020", term.getShortName());

        term = new Term("202050", "Unknown");
        assertEquals("202050", term.getTermCode());
        assertEquals("Unknown", term.getTermDescription());
        assertEquals("?/2020", term.getShortName());
    }

    @Test
    public void testToString() {
        Term term = new Term("202010", "Fall 2019");
        assertEquals("Term [code: 202010; description: Fall 2019]", term.toString());
    }
}
