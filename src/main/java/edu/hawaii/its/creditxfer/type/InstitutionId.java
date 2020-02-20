package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;

public class InstitutionId implements Serializable {

    private String code;
    private String mifValue;
    private String academicPeriodStart;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMifValue() {
        return mifValue;
    }

    public void setMifValue(String mifValue) {
        this.mifValue = mifValue;
    }

    public String getAcademicPeriodStart() {
        return academicPeriodStart;
    }

    public void setAcademicPeriodStart(String academicPeriodStart) {
        this.academicPeriodStart = academicPeriodStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        InstitutionId that = (InstitutionId) o;

        if (code != null ? !code.equals(that.code) : that.code != null)
            return false;
        if (mifValue != null ? !mifValue.equals(that.mifValue) : that.mifValue != null)
            return false;
        return academicPeriodStart != null ? academicPeriodStart.equals(that.academicPeriodStart) : that.academicPeriodStart == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (mifValue != null ? mifValue.hashCode() : 0);
        result = 31 * result + (academicPeriodStart != null ? academicPeriodStart.hashCode() : 0);
        return result;
    }
}
