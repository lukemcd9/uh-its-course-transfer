package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;

public class TargetId
    implements Serializable {

    private String sourceInstitutionCode;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String mifValue;
    private String academicPeriodStart;
    private Integer sequenceNumber;

    public String getSourceInstitutionCode() {
        return sourceInstitutionCode;
    }

    public void setSourceInstitutionCode(String sourceInstitutionCode) {
        this.sourceInstitutionCode = sourceInstitutionCode;
    }

    public String getSubjectCodeTrans() {
        return subjectCodeTrans;
    }

    public void setSubjectCodeTrans(String subjectCodeTrans) {
        this.subjectCodeTrans = subjectCodeTrans;
    }

    public String getCourseNumberTrans() {
        return courseNumberTrans;
    }

    public void setCourseNumberTrans(String courseNumberTrans) {
        this.courseNumberTrans = courseNumberTrans;
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

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TargetId targetId = (TargetId) o;

        if (sourceInstitutionCode != null ? !sourceInstitutionCode.equals(targetId.sourceInstitutionCode) : targetId.sourceInstitutionCode != null)
            return false;
        if (subjectCodeTrans != null ? !subjectCodeTrans.equals(targetId.subjectCodeTrans) : targetId.subjectCodeTrans != null)
            return false;
        if (courseNumberTrans != null ? !courseNumberTrans.equals(targetId.courseNumberTrans) : targetId.courseNumberTrans != null)
            return false;
        if (mifValue != null ? !mifValue.equals(targetId.mifValue) : targetId.mifValue != null)
            return false;
        if (academicPeriodStart != null ? !academicPeriodStart.equals(targetId.academicPeriodStart) : targetId.academicPeriodStart != null)
            return false;
        return sequenceNumber != null ? sequenceNumber.equals(targetId.sequenceNumber) : targetId.sequenceNumber == null;
    }

    @Override
    public int hashCode() {
        int result = sourceInstitutionCode != null ? sourceInstitutionCode.hashCode() : 0;
        result = 31 * result + (subjectCodeTrans != null ? subjectCodeTrans.hashCode() : 0);
        result = 31 * result + (courseNumberTrans != null ? courseNumberTrans.hashCode() : 0);
        result = 31 * result + (mifValue != null ? mifValue.hashCode() : 0);
        result = 31 * result + (academicPeriodStart != null ? academicPeriodStart.hashCode() : 0);
        result = 31 * result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
        return result;
    }
}
