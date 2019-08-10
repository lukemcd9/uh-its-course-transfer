package edu.hawaii.its.creditxfer.service;

import javax.persistence.EntityManager;

import edu.hawaii.its.creditxfer.type.Message;

public interface MessageService {

    public Message findMessage(int id);

    public Message add(Message message);

    public void evictCache();

    public Message update(Message message);

    public void setEntityManager(EntityManager em);

    public EntityManager getEntityManager();

}