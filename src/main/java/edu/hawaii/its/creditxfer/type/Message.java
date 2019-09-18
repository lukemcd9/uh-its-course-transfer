package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PS_MESSAGE", schema = "UHAPP_DB")
public class Message implements Serializable {

    public static final long serialVersionUID = 2L;
    public static final int GATE_MESSAGE = 1;
    public static final int ACCESS_DENIED_MESSAGE = 2;

    private Integer id;
    private Integer typeId;
    private String text;
    private String enabled;

    @Id
    @Column(name = "MSG_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "MSG_TEXT")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "MSG_ENABLED", columnDefinition = "char")
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Column(name = "MSG_TYPE_ID")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Message message = (Message) o;

        if (id != null ? !id.equals(message.id) : message.id != null)
            return false;
        if (typeId != null ? !typeId.equals(message.typeId) : message.typeId != null)
            return false;
        if (text != null ? !text.equals(message.text) : message.text != null)
            return false;
        return enabled != null ? enabled.equals(message.enabled) : message.enabled == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message [id=" + id
            + ", typeId=" + typeId
            + ", enabled=" + enabled
            + ", text=" + text
            + "]";
    }
}