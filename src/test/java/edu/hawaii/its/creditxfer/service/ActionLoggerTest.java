package edu.hawaii.its.creditxfer.service;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
import edu.hawaii.its.creditxfer.type.Action;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ActionLoggerTest {

    @Autowired
    private ActionLogger actionLogger;

    @Test
    public void construction() {
        assertNotNull(actionLogger);
    }

    @Test
    public void findActions() {
        List<Action> actions = actionLogger.findActions();
        assertNotEquals(0, actions.size());
    }

}
