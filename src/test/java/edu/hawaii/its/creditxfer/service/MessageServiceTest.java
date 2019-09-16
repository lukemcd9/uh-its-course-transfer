package edu.hawaii.its.creditxfer.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.creditxfer.configuration.SpringBootWebApplication;
import edu.hawaii.its.creditxfer.type.Message;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void find() {
        Message message = messageService.findMessage(Message.GATE_MESSAGE);
        assertEquals("Y", message.getEnabled());
        assertEquals(Integer.valueOf(Message.GATE_MESSAGE), message.getTypeId());
        assertTrue(message.getText().startsWith("University of Hawaii Information"));

        // Make sure the denied access message actually exists.
        messageService.evictCache();
        message = messageService.findMessage(Message.ACCESS_DENIED_MESSAGE);
        assertThat(message.getId(), equalTo(Message.ACCESS_DENIED_MESSAGE));
        assertThat(message.getText(), containsString("system is restricted"));
    }

    @Test
    public void update() {
        Message message = messageService.findMessage(Message.GATE_MESSAGE);
        assertEquals("Y", message.getEnabled());
        assertEquals(Integer.valueOf(1), message.getTypeId());
        assertTrue(message.getText().startsWith("University of Hawaii Information"));
        assertTrue(message.getText().endsWith("."));

        final String text = message.getText();

        message.setText("Stemming the bleeding.");
        messageService.update(message);

        message = messageService.findMessage(Message.GATE_MESSAGE);
        assertEquals("Y", message.getEnabled());
        assertEquals(Integer.valueOf(1), message.getTypeId());
        assertTrue(message.getText().equals("Stemming the bleeding."));

        // Put the original text back.
        message.setText(text);
        messageService.update(message);
        assertTrue(message.getText().startsWith("University of Hawaii Information"));
        assertTrue(message.getText().endsWith("."));
    }

    @Test
    public void messageCache() {
        Message m0 = messageService.findMessage(Message.GATE_MESSAGE);
        Message m1 = messageService.findMessage(Message.GATE_MESSAGE);

        assertEquals(m0.toString(), m1.toString());

        final String text = m0.getText();

        m0.setText("This land is your land.");
        messageService.update(m0);
        assertSame(m0, m1);

        m1 = messageService.findMessage(Message.GATE_MESSAGE);
        assertSame(m0, m1);

        Message m2 = messageService.findMessage(Message.GATE_MESSAGE);
        assertSame(m0, m2);
        assertSame(m1, m2);

        //Put the original text back.
        m0.setText(text);
        messageService.update(m0);
        assertTrue(m0.getText().startsWith("University of Hawaii Information"));
        assertTrue(m0.getText().endsWith("."));

        Message m3 = new Message();
        m3.setId(999);
        m3.setEnabled("Y");
        m3.setText("Testing");
        m3.setTypeId(1);
        messageService.add(m3);

        Message m4 = messageService.findMessage(999);
        assertEquals(m4, m3);
        assertSame(m4, m3);
    }

}