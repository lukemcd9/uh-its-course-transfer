package edu.hawaii.its.creditxfer.action;

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
public class ActionListenerSystemTest {

    @Autowired
    private ActionListener actionListener;

    @Test
    public void mapNotEmpty() {
        assertTrue(actionListener.mapSize() > 0);
    }
}
