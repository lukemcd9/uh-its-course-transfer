package edu.hawaii.its.creditxfer.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public interface EmployeeService {
    public boolean exists(String uhuuid);

    public EntityManager getEntityManager();

    public void setEntityManager(EntityManager em);
}
