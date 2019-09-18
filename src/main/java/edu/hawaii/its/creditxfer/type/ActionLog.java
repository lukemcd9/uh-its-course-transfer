package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIONLOG", schema = "UHAPP_DB")
public class ActionLog implements Serializable {

    private static final long serialVersionUID = 2L;
    private Long id;
    private Long actionId;
    private String userUhuuid; // Logged in user.
    private Long viewUhuuid; // User viewed.

    public ActionLog() {
        // Empty. Required for JPA.
    }

    public ActionLog(Long actionId, String userUhuuid) {
        this.actionId = actionId;
        this.userUhuuid = userUhuuid;
    }

    @Id
    @Column(name = "ACTLOG_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actionlog_seq_gen")
    @SequenceGenerator(name = "actionlog_seq_gen", sequenceName = "UHAPP_DB.ACTIONLOG_SEQ")
    public Long getId() {
        return id;
    }

    @Column(name = "ACTION_ID")
    public Long getActionId() {
        return actionId;
    }

    @Column(name = "ACTLOG_USER_UHNUMBER")
    public String getUserUhuuid() {
        return userUhuuid;
    }

    @Column(name = "ACTLOG_VIEW_UHNUMBER")
    public Long getViewUhuuid() {
        return viewUhuuid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public void setUserUhuuid(String userUhuuid) {
        this.userUhuuid = userUhuuid;
    }

    public void setViewUhuuid(Long viewUhuuid) {
        this.viewUhuuid = viewUhuuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ActionLog actionLog = (ActionLog) o;

        if (id != null ? !id.equals(actionLog.id) : actionLog.id != null)
            return false;
        if (actionId != null ? !actionId.equals(actionLog.actionId) : actionLog.actionId != null)
            return false;
        if (userUhuuid != null ? !userUhuuid.equals(actionLog.userUhuuid) : actionLog.userUhuuid != null)
            return false;
        return viewUhuuid != null ? viewUhuuid.equals(actionLog.viewUhuuid) : actionLog.viewUhuuid == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (actionId != null ? actionId.hashCode() : 0);
        result = 31 * result + (userUhuuid != null ? userUhuuid.hashCode() : 0);
        result = 31 * result + (viewUhuuid != null ? viewUhuuid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActionLog [id=" + id
            + ", actionId=" + actionId
            + ", userUhuuid=" + userUhuuid
            + ", viewUhuuid=" + viewUhuuid
            + "]";
    }
}
