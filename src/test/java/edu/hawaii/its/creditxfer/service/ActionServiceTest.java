package edu.hawaii.its.creditxfer.service;

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
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
import edu.hawaii.its.creditxfer.type.Action;
import edu.hawaii.its.creditxfer.type.ActionLog;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ActionServiceTest {

    @Autowired
    private ActionService actionService;

    @Test
    public void construction() {
        assertNotNull(actionService);
    }

    @Test
    public void findAction() {
        Action action = actionService.findAction(10L);
        assertNotNull(action);
        assertEquals(action.getEnabled(), "N");
        assertEquals(action.getCode(), "employee.view.home");
        assertEquals(action.getDescription(), "Employee viewing homepage.");
    }

    @Test
    @Transactional
    public void record() {
        long count = actionService.logCount();
        assertEquals(0, count);

        final long RUNS = 10;
        for (int i = 0; i < RUNS; i++) {
            ActionLog actionLog = new ActionLog();
            actionLog.setActionId(Long.valueOf(10 + (i % 3)));
            actionLog.setUserUhuuid(String.valueOf(89999999));
            actionLog.setViewUhuuid(Long.valueOf(89999999));

            actionService.record(actionLog);
        }

        assertEquals(count + RUNS, actionService.logCount());
    }

    @Test
    public void testEquals() {
        Action a1 = new Action();
        assertThat(a1, equalTo(a1));
        Action a2 = null;
        assertThat(a1, not(equalTo(a2)));
        a2 = new Action();
        assertThat(a1, equalTo(a2));
        a1.setId(1L);
        assertThat(a1, not(equalTo(a2)));
        a2.setId(1L);
        assertThat(a1, equalTo(a2));
        a2.setId(2L);
        assertThat(a1, not(equalTo(a2)));
        a1.setId(null);
        a2.setId(2L);
        assertThat(a1, not(equalTo(a2)));
        // Wrong class.
        assertThat(a1, not(equalTo(new String())));
    }

    @Test
    public void testHashCode() {
        Action a0 = new Action();
        Action a1 = new Action();
        assertThat(a0, equalTo(a1));
        assertThat(a1, equalTo(a0));
        assertThat(a0.hashCode(), equalTo(a1.hashCode()));
        assertThat(a1.hashCode(), equalTo(a0.hashCode()));
        a0.setId(1L);
        assertThat(a0, not(equalTo(a1)));
        assertThat(a1, not(equalTo(a0)));
        assertThat(a0.hashCode(), not(equalTo(a1.hashCode())));
        assertThat(a1.hashCode(), not(equalTo(a0.hashCode())));
        a1.setId(a0.getId());
        assertThat(a0, equalTo(a1));
        assertThat(a1, equalTo(a0));
        assertThat(a0.hashCode(), equalTo(a1.hashCode()));
        assertThat(a1.hashCode(), equalTo(a0.hashCode()));
        a0.setCode("code");
        assertThat(a0, not(equalTo(a1)));
        assertThat(a1, not(equalTo(a0)));
        assertThat(a0.hashCode(), not(equalTo(a1.hashCode())));
        assertThat(a1.hashCode(), not(equalTo(a0.hashCode())));
        a1.setCode(a0.getCode());
        assertThat(a0, equalTo(a1));
        assertThat(a1, equalTo(a0));
        assertThat(a0.hashCode(), equalTo(a1.hashCode()));
        assertThat(a1.hashCode(), equalTo(a0.hashCode()));
        a0.setDescription("description");
        assertThat(a0, not(equalTo(a1)));
        assertThat(a1, not(equalTo(a0)));
        assertThat(a0.hashCode(), not(equalTo(a1.hashCode())));
        assertThat(a1.hashCode(), not(equalTo(a0.hashCode())));
        a1.setDescription("description");
        assertThat(a0, equalTo(a1));
        assertThat(a1, equalTo(a0));
        assertThat(a0.hashCode(), equalTo(a1.hashCode()));
        assertThat(a1.hashCode(), equalTo(a0.hashCode()));
        a0.setEnabled("enabled");
        assertThat(a0, not(equalTo(a1)));
        assertThat(a1, not(equalTo(a0)));
        assertThat(a0.hashCode(), not(equalTo(a1.hashCode())));
        assertThat(a1.hashCode(), not(equalTo(a0.hashCode())));
        a1.setEnabled("enabled");
        assertThat(a0, equalTo(a1));
        assertThat(a1, equalTo(a0));
        assertThat(a0.hashCode(), equalTo(a1.hashCode()));
        assertThat(a1.hashCode(), equalTo(a0.hashCode()));
        assertThat(a0.equals(a0), equalTo(true));
        assertThat(a0.equals(null), equalTo(false));
        assertThat(a0.equals(new String()), equalTo(false));
    }
}
