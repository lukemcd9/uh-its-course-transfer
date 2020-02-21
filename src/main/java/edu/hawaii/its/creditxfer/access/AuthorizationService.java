package edu.hawaii.its.creditxfer.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hawaii.its.creditxfer.service.AdministratorService;

@Service
public class AuthorizationService {

    @Autowired
    private AdministratorService administratorService;

    public RoleHolder fetchRoles(String uhUuid) {
        RoleHolder roleHolder = new RoleHolder();

        roleHolder.add(Role.USER);

        if (administratorService.exists(uhUuid)) {
            roleHolder.add(Role.ADMIN);
        }

        return roleHolder;
    }

}
