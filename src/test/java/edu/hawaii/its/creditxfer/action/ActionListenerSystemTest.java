package edu.hawaii.its.creditxfer.action;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.hawaii.its.creditxfer.configuration.CachingConfig;
import edu.hawaii.its.creditxfer.configuration.DatabaseConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DatabaseConfig.class, CachingConfig.class })
public class ActionListenerSystemTest {

    @Autowired
    private ActionListener actionListener;

    @Test
    public void mapNotEmpty() {
        assertTrue(actionListener.mapSize() > 0);
    }
}
