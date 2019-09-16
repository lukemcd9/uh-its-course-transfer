package edu.hawaii.its.creditxfer.service;

import java.util.List;

import edu.hawaii.its.creditxfer.type.Action;
import edu.hawaii.its.creditxfer.type.ActionLog;

public interface ActionService {
    List<Action> findActions();

    Action findAction(Long id);

    void record(ActionLog actionLog);

    long logCount();
}
