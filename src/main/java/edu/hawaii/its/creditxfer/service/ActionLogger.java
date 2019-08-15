package edu.hawaii.its.creditxfer.service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.hawaii.its.creditxfer.type.Action;

public interface ActionLogger {
    public List<Action> findActions();

    public EntityManager getEntityManager();
}
