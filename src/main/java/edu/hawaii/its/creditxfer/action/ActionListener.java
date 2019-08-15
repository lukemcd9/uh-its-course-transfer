package edu.hawaii.its.creditxfer.action;

import java.util.Map;

import org.springframework.context.ApplicationListener;

import edu.hawaii.its.creditxfer.service.ActionService;
import edu.hawaii.its.creditxfer.type.Action;

public interface ActionListener extends ApplicationListener<ActionEvent> {
    public int mapSize();

    public ActionService getActionService();

    public void setActionService(ActionService actionService);

    public void fillActionMap();

    public void setActionMap(Map<String, Action> actionMap);
}
