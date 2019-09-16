package edu.hawaii.its.creditxfer.service;

import java.util.List;

import edu.hawaii.its.creditxfer.type.Action;

public interface ActionLogger {
    List<Action> findActions();
}
