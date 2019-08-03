package edu.hawaii.its.creditxfer.service;

import edu.hawaii.its.creditxfer.type.Message;

public interface MessageService {

    public Message findMessage(int id);

    public Message add(Message message);

    public Message update(Message message);

}
