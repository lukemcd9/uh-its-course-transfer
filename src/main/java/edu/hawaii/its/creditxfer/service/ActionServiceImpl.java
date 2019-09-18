package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.repository.ActionLoggerRepository;
import edu.hawaii.its.creditxfer.repository.ActionRepository;
import edu.hawaii.its.creditxfer.type.Action;
import edu.hawaii.its.creditxfer.type.ActionLog;

/**
 * A JPA-based implementation of the Action Service. Delegates to a JPA entity
 * manager to issue data access calls against the backing repository. The
 * EntityManager reference is provided by the managing container (Spring)
 * automatically.
 */
@Service("actionService")
@Repository
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private ActionLoggerRepository actionLoggerRepository;

    @Transactional(readOnly = true)
    public List<Action> findActions() { return actionRepository.findAllByOrderById(); }

    public Action findAction(Long id) {
        return actionRepository.findById(id);
    }

    @Transactional
    public void record(ActionLog actionLog) {
        actionLoggerRepository.save(actionLog);
    }

    @Override
    public long logCount() {
        return actionLoggerRepository.count();
    }
}