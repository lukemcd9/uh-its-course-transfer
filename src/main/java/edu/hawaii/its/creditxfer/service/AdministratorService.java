package edu.hawaii.its.creditxfer.service;

import java.util.List;

public interface AdministratorService {
    public boolean exists(String uhuuid);

    public void setAdmins(List<String> admins);

    public List<String> getAdmins();
}
