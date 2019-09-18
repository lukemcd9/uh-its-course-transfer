package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UNIQUE_UH_NUMBER_V", schema = "UHAPP_DB")
public class Employee implements Serializable {

    public static final long serialVersionUID = 2L;
    private Long uhNumber;

    public Employee() {
        // Empty.
    }

    public Employee(Long uhNumber) {
        this.uhNumber = uhNumber;
    }

    @Id
    @Column(name = "UH_NUMBER")
    public Long getUhNumber() {
        return uhNumber;
    }

    public void setUhNumber(Long uhNumber) {
        this.uhNumber = uhNumber;
    }

    @Override
    public String toString() {
        return "Employee [uhNumber=" + uhNumber + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Employee employee = (Employee) o;

        return uhNumber != null ? uhNumber.equals(employee.uhNumber) : employee.uhNumber == null;
    }

    @Override
    public int hashCode() {
        return uhNumber != null ? uhNumber.hashCode() : 0;
    }
}
