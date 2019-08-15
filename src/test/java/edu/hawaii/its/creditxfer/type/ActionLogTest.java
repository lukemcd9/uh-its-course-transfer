package edu.hawaii.its.creditxfer.type;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ActionLogTest {

    @Test
    public void construction() {
        ActionLog actionLog = new ActionLog(1L, "12345");
        assertNotNull(actionLog);
        assertEquals(actionLog.getActionId(), Long.valueOf(1L));
        assertEquals(actionLog.getUserUhuuid(), "12345");
    }

    @Test
    public void testToString() {
        ActionLog actionLog = new ActionLog();
        String expected = "ActionLog [id=null";
        assertThat(actionLog.toString(), containsString(expected));

        actionLog.setActionId(1L);
        actionLog.setId(1L);
        actionLog.setUserUhuuid("12345");
        actionLog.setViewUhuuid(12345L);

        assertEquals(actionLog.toString(), "ActionLog [id=1, actionId=1, userUhuuid=12345, viewUhuuid=12345]");
    }
}
