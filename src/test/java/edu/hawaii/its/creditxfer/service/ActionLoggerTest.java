package edu.hawaii.its.creditxfer.service;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
import edu.hawaii.its.creditxfer.type.ActionLog;

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

        List<ActionLog> actionLogs = actionLogger.findActionLogs();
        assertEquals(0, actionLogs.size());
    }

    @Test
    public void testEquals() {
        ActionLog l1 = new ActionLog();
        assertThat(l1, equalTo(l1));
        ActionLog l2 = null;
        assertThat(l1, not(equalTo(l2)));
        l2 = new ActionLog();
        assertThat(l1, equalTo(l2));
        l1.setId(1L);
        assertThat(l1, not(equalTo(l2)));
        l2.setId(1L);
        assertThat(l1, equalTo(l2));
        l2.setId(2L);
        assertThat(l1, not(equalTo(l2)));
        l1.setId(null);
        l2.setId(2L);
        assertThat(l1, not(equalTo(l2)));
        // Wrong class.
        assertThat(l1, not(equalTo(new String())));
    }

    @Test
    public void testHashCode() {
        ActionLog l0 = new ActionLog();
        ActionLog l1 = new ActionLog();
        assertThat(l0, equalTo(l1));
        assertThat(l1, equalTo(l0));
        assertThat(l0.hashCode(), equalTo(l1.hashCode()));
        assertThat(l1.hashCode(), equalTo(l0.hashCode()));
        l0.setId(1L);
        assertThat(l0, not(equalTo(l1)));
        assertThat(l1, not(equalTo(l0)));
        assertThat(l0.hashCode(), not(equalTo(l1.hashCode())));
        assertThat(l1.hashCode(), not(equalTo(l0.hashCode())));
        l1.setId(l0.getId());
        assertThat(l0, equalTo(l1));
        assertThat(l1, equalTo(l0));
        assertThat(l0.hashCode(), equalTo(l1.hashCode()));
        assertThat(l1.hashCode(), equalTo(l0.hashCode()));
        l0.setViewUhuuid(1L);
        assertThat(l0, not(equalTo(l1)));
        assertThat(l1, not(equalTo(l0)));
        assertThat(l0.hashCode(), not(equalTo(l1.hashCode())));
        assertThat(l1.hashCode(), not(equalTo(l0.hashCode())));
        l1.setViewUhuuid(l0.getViewUhuuid());
        assertThat(l0, equalTo(l1));
        assertThat(l1, equalTo(l0));
        assertThat(l0.hashCode(), equalTo(l1.hashCode()));
        assertThat(l1.hashCode(), equalTo(l0.hashCode()));
        l0.setUserUhuuid("uhuuid");
        assertThat(l0, not(equalTo(l1)));
        assertThat(l1, not(equalTo(l0)));
        assertThat(l0.hashCode(), not(equalTo(l1.hashCode())));
        assertThat(l1.hashCode(), not(equalTo(l0.hashCode())));
        l1.setUserUhuuid("uhuuid");
        assertThat(l0, equalTo(l1));
        assertThat(l1, equalTo(l0));
        assertThat(l0.hashCode(), equalTo(l1.hashCode()));
        assertThat(l1.hashCode(), equalTo(l0.hashCode()));
        l0.setActionId(1L);
        assertThat(l0, not(equalTo(l1)));
        assertThat(l1, not(equalTo(l0)));
        assertThat(l0.hashCode(), not(equalTo(l1.hashCode())));
        assertThat(l1.hashCode(), not(equalTo(l0.hashCode())));
        l1.setActionId(1L);
        assertThat(l0, equalTo(l1));
        assertThat(l1, equalTo(l0));
        assertThat(l0.hashCode(), equalTo(l1.hashCode()));
        assertThat(l1.hashCode(), equalTo(l0.hashCode()));
        assertThat(l0.equals(l0), equalTo(true));
        assertThat(l0.equals(null), equalTo(false));
        assertThat(l0.equals(new String()), equalTo(false));
    }
}
