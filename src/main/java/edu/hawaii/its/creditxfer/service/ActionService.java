package edu.hawaii.its.creditxfer.service;

import java.util.List;

import javax.persistence.EntityManager;

import edu.hawaii.its.creditxfer.type.Action;
import edu.hawaii.its.creditxfer.type.ActionLog;

public interface ActionService {
    public List<Action> findActions();

    public Action findAction(Long id);

    public void record(ActionLog actionLog);

    public long logCount();

    public EntityManager getEntityManager();
}
