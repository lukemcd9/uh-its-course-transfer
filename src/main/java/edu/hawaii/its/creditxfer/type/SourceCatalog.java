package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MST_TRANSFER_CATALOG_SOURCE_UH", schema = "ODSMGR")
@IdClass(SourceId.class)
public class SourceCatalog implements Serializable {

    public static final long serialVersionUID = 2L;

    private String sourceInstitutionCode;
    private String mifValue;
    private String academicPeriodStart;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String courseTitleTrans;
    private Date transCourseActivityDate;

    @Id
    @Column(name="SOURCE_INSTITUTION_CODE")
    public String getSourceInstitutionCode() {
        return sourceInstitutionCode;
    }

    public void setSourceInstitutionCode(String sourceInstitutionCode) {
        this.sourceInstitutionCode = sourceInstitutionCode;
    }

    @Id
    @Column(name="MIF_VALUE")
    public String getMifValue() {
        return mifValue;
    }

    public void setMifValue(String mifValue) {
        this.mifValue = mifValue;
    }

    @Id
    @Column(name="ACADEMIC_PERIOD_START")
    public String getAcademicPeriodStart() {
        return academicPeriodStart;
    }

    public void setAcademicPeriodStart(String academicPeriodStart) {
        this.academicPeriodStart = academicPeriodStart;
    }

    @Id
    @Column(name="SUBJECT_CODE_TRANS")
    public String getSubjectCodeTrans() {
        return subjectCodeTrans;
    }

    public void setSubjectCodeTrans(String subjectCodeTrans) {
        this.subjectCodeTrans = subjectCodeTrans;
    }

    @Id
    @Column(name="COURSE_NUMBER_TRANS")
    public String getCourseNumberTrans() {
        return courseNumberTrans;
    }

    public void setCourseNumberTrans(String courseNumberTrans) {
        this.courseNumberTrans = courseNumberTrans;
    }

    @Column(name="COURSE_TITLE_TRANS")
    public String getCourseTitleTrans() {
        return courseTitleTrans;
    }

    public void setCourseTitleTrans(String courseTitleTrans) {
        this.courseTitleTrans = courseTitleTrans;
    }

    @Column(name="TRANS_COURSE_ACTIVITY_DATE")
    public Date getTransCourseActivityDate() {
        return transCourseActivityDate;
    }

    public void setTransCourseActivityDate(Date transCourseActivityDate) {
        this.transCourseActivityDate = transCourseActivityDate;
    }

    @Override
    public String toString() {
        return "SourceCatalog [sourceInstitutionCode=" + sourceInstitutionCode
            + ", mifValue=" + mifValue
            + ", academicPeriodStart=" + academicPeriodStart
            + ", subjectCodeTrans=" + subjectCodeTrans
            + ", courseNumberTrans=" + courseNumberTrans
            + ", courseTitleTrans=" + courseTitleTrans
            + ", transCourseActivityDate=" + transCourseActivityDate
            + "]";
    }
}
