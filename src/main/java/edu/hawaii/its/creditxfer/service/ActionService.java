package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.repository.ActionLoggerRepository;
import edu.hawaii.its.creditxfer.repository.ActionRepository;
import edu.hawaii.its.creditxfer.type.Action;
import edu.hawaii.its.creditxfer.type.ActionLog;

@Service
public class ActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private ActionLoggerRepository actionLoggerRepository;

    @Transactional(readOnly = true)
    public List<Action> findActions() {
        return actionRepository.findAllByOrderById();
    }

    public Action findAction(Long id) {
        return actionRepository.findById(id);
    }

    @Transactional
    public void record(ActionLog actionLog) {
        actionLoggerRepository.save(actionLog);
    }

    public long logCount() {
        return actionLoggerRepository.count();
    }
}