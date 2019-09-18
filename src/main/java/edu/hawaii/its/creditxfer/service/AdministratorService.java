package edu.hawaii.its.creditxfer.service;

import java.util.List;

public interface AdministratorService {
    boolean exists(String uhuuid);

    void setAdmins(List<String> admins);

    List<String> getAdmins();
}
