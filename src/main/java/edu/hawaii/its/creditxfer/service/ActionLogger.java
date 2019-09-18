package edu.hawaii.its.creditxfer.service;

import java.util.List;

import edu.hawaii.its.creditxfer.type.ActionLog;

public interface ActionLogger {
    List<ActionLog> findActionLogs();
}
