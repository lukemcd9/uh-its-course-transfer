package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Value("#{'${admin.list}'.split(',')}")
    private List<String> admins;

    public void setAdmins(List<String> admins) {
        this.admins = admins;
    }

    public List<String> getAdmins() {
        return admins;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(String uhuuid) {
        if (admins != null && !admins.isEmpty()) {
            return admins.contains(uhuuid);
        }
        return false;
    }
}