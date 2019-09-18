package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.repository.ActionLoggerRepository;
import edu.hawaii.its.creditxfer.type.ActionLog;

@Service("actionLogger")
public class ActionLoggerImpl implements ActionLogger {

    @Autowired
    private ActionLoggerRepository actionLoggerRepository;

    @Transactional(readOnly = true)
    public List<ActionLog> findActionLogs() {
        return actionLoggerRepository.findAllByOrderById();
    }
}