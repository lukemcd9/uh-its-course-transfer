package edu.hawaii.its.creditxfer.type;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class MessageTest {

    @Test
    public void testToString() {
        Message message = new Message();
        String expected = "Message [id=null,";
        assertThat(message.toString(), containsString(expected));

        message.setId(5);
        message.setText("Hello Message");
        message.setEnabled("N");
        message.setTypeId(5);
        assertThat(message.toString(), containsString("Message [id=5, typeId=5, enabled=N, text=Hello Message]"));
    }
}
