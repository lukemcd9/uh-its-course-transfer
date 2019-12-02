package edu.hawaii.its.creditxfer.access;

import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    
    public RoleHolder fetchRoles(String uhUuid) {
        RoleHolder roleHolder = new RoleHolder();

        roleHolder.add(Role.USER);
        roleHolder.add(Role.ADMIN);

        return roleHolder;
    }

}
