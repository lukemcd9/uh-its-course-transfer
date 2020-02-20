package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;

public class SourceId
    implements Serializable {

    private String sourceInstitutionCode;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String mifValue;
    private String academicPeriodStart;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SourceId sourceId = (SourceId) o;

        if (sourceInstitutionCode != null ? !sourceInstitutionCode.equals(sourceId.sourceInstitutionCode) : sourceId.sourceInstitutionCode != null)
            return false;
        if (subjectCodeTrans != null ? !subjectCodeTrans.equals(sourceId.subjectCodeTrans) : sourceId.subjectCodeTrans != null)
            return false;
        if (courseNumberTrans != null ? !courseNumberTrans.equals(sourceId.courseNumberTrans) : sourceId.courseNumberTrans != null)
            return false;
        if (mifValue != null ? !mifValue.equals(sourceId.mifValue) : sourceId.mifValue != null)
            return false;
        return academicPeriodStart != null ? academicPeriodStart.equals(sourceId.academicPeriodStart) : sourceId.academicPeriodStart == null;
    }

    @Override
    public int hashCode() {
        int result = sourceInstitutionCode != null ? sourceInstitutionCode.hashCode() : 0;
        result = 31 * result + (subjectCodeTrans != null ? subjectCodeTrans.hashCode() : 0);
        result = 31 * result + (courseNumberTrans != null ? courseNumberTrans.hashCode() : 0);
        result = 31 * result + (mifValue != null ? mifValue.hashCode() : 0);
        result = 31 * result + (academicPeriodStart != null ? academicPeriodStart.hashCode() : 0);
        return result;
    }
}
