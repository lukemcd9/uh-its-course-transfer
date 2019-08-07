package edu.hawaii.its.creditxfer.access;

public interface AuthorizationService {
    public RoleHolder fetchRoles(String uhUuid);

    public RoleHolder fetchRoles(String uhUuid, boolean isAuthenticated);
}
