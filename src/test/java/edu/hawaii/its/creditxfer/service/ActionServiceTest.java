package edu.hawaii.its.creditxfer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
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

}
