package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.repository.ActionLoggerRepository;
import edu.hawaii.its.creditxfer.type.ActionLog;

/**
 * A JPA-based implementation of the ActionLogger Service. Delegates to a JPA entity
 * manager to issue data access calls against the backing repository. The
 * EntityManager reference is provided by the managing container (Spring)
 * automatically.
 */
@Repository
public class ActionLoggerImpl implements ActionLogger {

    @Autowired
    private ActionLoggerRepository actionLoggerRepository;

    @Transactional(readOnly = true)
    public List<ActionLog> findActionLogs() {
        return actionLoggerRepository.findAllByOrderById();
    }
}