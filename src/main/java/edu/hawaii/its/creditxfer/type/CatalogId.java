package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;
import java.sql.Date;

public class CatalogId implements Serializable {

    private String mifValue;
    private String sourceInstitutionCode;
    private String courseIdTrans;
    private String courseIdEquiv;
    private Date transCourseActivityDate;
    private Date equivCourseActivityDate;
    private String academicPeriodStart;
    private Integer equivCreditsUsed;
    private Integer sequenceNumber;

    public String getMifValue() {
        return mifValue;
    }

    public void setMifValue(String mifValue) {
        this.mifValue = mifValue;
    }

    public String getSourceInstitutionCode() {
        return sourceInstitutionCode;
    }

    public void setSourceInstitutionCode(String sourceInstitutionCode) {
        this.sourceInstitutionCode = sourceInstitutionCode;
    }

    public String getCourseIdTrans() {
        return courseIdTrans;
    }

    public void setCourseIdTrans(String courseIdTrans) {
        this.courseIdTrans = courseIdTrans;
    }

    public String getCourseIdEquiv() {
        return courseIdEquiv;
    }

    public void setCourseIdEquiv(String courseIdEquiv) {
        this.courseIdEquiv = courseIdEquiv;
    }

    public Date getTransCourseActivityDate() {
        return transCourseActivityDate;
    }

    public void setTransCourseActivityDate(Date transCourseActivityDate) {
        this.transCourseActivityDate = transCourseActivityDate;
    }

    public Date getEquivCourseActivityDate() {
        return equivCourseActivityDate;
    }

    public void setEquivCourseActivityDate(Date equivCourseActivityDate) {
        this.equivCourseActivityDate = equivCourseActivityDate;
    }

    public String getAcademicPeriodStart() {
        return academicPeriodStart;
    }

    public void setAcademicPeriodStart(String academicPeriodStart) {
        this.academicPeriodStart = academicPeriodStart;
    }

    public Integer getEquivCreditsUsed() {
        return equivCreditsUsed;
    }

    public void setEquivCreditsUsed(Integer equivCreditsUsed) {
        this.equivCreditsUsed = equivCreditsUsed;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}
