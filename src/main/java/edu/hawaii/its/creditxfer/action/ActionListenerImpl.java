package edu.hawaii.its.creditxfer.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import edu.hawaii.its.creditxfer.service.ActionService;
import edu.hawaii.its.creditxfer.type.Action;
import edu.hawaii.its.creditxfer.type.ActionLog;

@Service("actionListener")
public class ActionListenerImpl implements ActionListener {

    private static final Logger logger = LoggerFactory.getLogger(ActionListenerImpl.class);

    private Map<String, Action> actionMap = new HashMap<String, Action>();

    @Autowired
    private ActionService actionService;

    public ActionListenerImpl() {
        super();
    }

    @PostConstruct
    public void fillActionMap() {
        logger.debug("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
        try {
            synchronized (actionMap) {
                if (actionMap.isEmpty()) {
                    List<Action> actions = actionService.findActions();
                    for (Action a : actions) {
                        logger.debug("> loading action: " + a);
                        actionMap.put(a.getCode(), a);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error", e);
        }
        Assert.notEmpty(actionMap, "Map is empty.");
        logger.debug("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    @Transactional
    public void onApplicationEvent(ActionEvent event) {
        try {
            Action action = actionMap.get(event.getCode());
            if (action != null && action.isActionEnabled()) {
                ActionLog actionEntry = new ActionLog();
                actionEntry.setActionId(action.getId());
                actionEntry.setUserUhuuid(event.getUhuuid());
                actionEntry.setViewUhuuid(event.getViewUhuuid());

                logger.info("Saving: " + actionEntry);
                actionService.record(actionEntry);
            }
        } catch (Exception e) {
            logger.error("Exception:", e);
        }
    }

    public int mapSize() {
        return actionMap.size();
    }


    public ActionService getActionService() {
        return actionService;
    }

    public void setActionService(ActionService actionService) {
        this.actionService = actionService;
    }

    public void setActionMap(Map<String, Action> actionMap) {
        this.actionMap = actionMap;
    }
}