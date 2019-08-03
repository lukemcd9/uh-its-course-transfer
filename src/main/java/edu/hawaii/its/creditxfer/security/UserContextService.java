package edu.hawaii.its.creditxfer.security;

import edu.hawaii.its.creditxfer.access.UhAttributes;
import edu.hawaii.its.creditxfer.access.User;

public interface UserContextService {
    public abstract User getCurrentUser();

    public abstract String getCurrentUsername();

    public abstract Long getCurrentUhuuid();

    public void setCurrentUhuuid(Long uhuuid);

    public String getAttribute(String name);

    public UhAttributes getAttributes();
}