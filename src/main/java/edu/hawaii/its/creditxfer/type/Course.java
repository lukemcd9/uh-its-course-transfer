package edu.hawaii.its.creditxfer.type;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MST_TRANSFER_EQUIV_ATTR_UH", schema = "ODSMGR")
@IdClass(CourseId.class)
public class Course {

    public static final long serialVersionUID = 2L;

    private String sourceInstitutionCode;
    private String mifValue;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String subjectCodeEquiv;
    private String courseNumberEquiv;
    private String academicPeriodStart;
    private String equivCourseAttribute;
    private String equivCourseAttributeDesc;
    private Date equivAttrActivityDate;

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

    @Id
    @Column(name="SUBJECT_CODE_EQUIV")
    public String getSubjectCodeEquiv() {
        return subjectCodeEquiv;
    }

    public void setSubjectCodeEquiv(String subjectCodeEquiv) {
        this.subjectCodeEquiv = subjectCodeEquiv;
    }

    @Id
    @Column(name="COURSE_NUMBER_EQUIV")
    public String getCourseNumberEquiv() {
        return courseNumberEquiv;
    }

    public void setCourseNumberEquiv(String courseNumberEquiv) {
        this.courseNumberEquiv = courseNumberEquiv;
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
    @Column(name="EQUIV_COURSE_ATTRIBUTE")
    public String getEquivCourseAttribute() {
        return equivCourseAttribute;
    }

    public void setEquivCourseAttribute(String equivCourseAttribute) {
        this.equivCourseAttribute = equivCourseAttribute;
    }

    @Column(name="EQUIV_COURSE_ATTRIBUTE_DESC")
    public String getEquivCourseAttributeDesc() {
        return equivCourseAttributeDesc;
    }

    public void setEquivCourseAttributeDesc(String equivCourseAttributeDesc) {
        this.equivCourseAttributeDesc = equivCourseAttributeDesc;
    }

    @Column(name="EQUIV_ATTR_ACTIVITY_DATE")
    public Date getEquivAttrActivityDate() {
        return equivAttrActivityDate;
    }

    public void setEquivAttrActivityDate(Date equivAttrActivityDate) {
        this.equivAttrActivityDate = equivAttrActivityDate;
    }

    @Override
    public String toString() {
        return "Course [sourceInstitutionCode=" + sourceInstitutionCode
            + ", mifValue=" + mifValue
            + ", academicPeriodStart=" + academicPeriodStart
            + ", subjectCodeTrans=" + subjectCodeTrans
            + ", courseNumberTrans=" + courseNumberTrans
            + ", subjectCodeEquiv=" + subjectCodeEquiv
            + ", courseNumberEquiv=" + courseNumberEquiv
            + ", equivCourseAttribute=" + equivCourseAttribute
            + ", equivCourseAttributeDesc=" + equivCourseAttributeDesc
            + ", equivAttrActivityDate=" + equivAttrActivityDate
            + "]";
    }
}
