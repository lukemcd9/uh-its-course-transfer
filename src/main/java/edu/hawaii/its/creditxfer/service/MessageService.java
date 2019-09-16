package edu.hawaii.its.creditxfer.service;

import edu.hawaii.its.creditxfer.type.Message;

public interface MessageService {

    Message findMessage(Integer id);

    Message add(Message message);

    void evictCache();

    Message update(Message message);
}