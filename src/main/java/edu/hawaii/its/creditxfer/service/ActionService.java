package edu.hawaii.its.creditxfer.service;

import java.util.List;

import edu.hawaii.its.creditxfer.type.Action;
import edu.hawaii.its.creditxfer.type.ActionLog;

public interface ActionService {
    public List<Action> findActions();

    public void record(ActionLog actionLog);

    public long logCount();
}
