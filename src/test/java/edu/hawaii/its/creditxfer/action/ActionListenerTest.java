package edu.hawaii.its.creditxfer.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
public class ActionListenerTest {

    @Autowired
    private ActionListener actionListener;

    @Autowired
    private ActionRecorder actionRecorder;

    @Test
    public void fillActionTest() {
        assertTrue(actionListener.mapSize() > 0);

        actionListener.setActionService(null);
        actionListener.fillActionMap();
        assertEquals(actionListener.mapSize(), 12);

        actionListener.setActionMap(null);
        try {
            actionListener.fillActionMap();
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void onApplicationEventTest() {
        ActionEvent actionEvent = new ActionEvent(this, "code", "uhuuid", 123L);
        actionListener.onApplicationEvent(actionEvent);
        assertEquals(actionListener.getActionService().logCount(), 0);

        actionListener.onApplicationEvent(null);
        assertEquals(actionListener.getActionService().logCount(), 0);

        actionRecorder.publish("employee.view.home", "234");
        assertEquals(actionListener.getActionService().logCount(), 0);

        actionRecorder.publish("employee.view.creditxfer", "345678", 345678L);
        assertEquals(actionListener.getActionService().logCount(), 1);
    }

    @Test
    public void testToString() {
        ActionEvent actionEvent = new ActionEvent(this, "code", "myId", 123L);
        assertEquals(actionEvent.toString(), "ActionEvent [, uhuuid=myId, viewUhuuid=123, code=code]");
    }
}
