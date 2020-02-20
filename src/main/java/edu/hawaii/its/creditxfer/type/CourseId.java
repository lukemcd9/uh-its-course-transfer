package edu.hawaii.its.creditxfer.type;

import java.io.Serializable;

public class CourseId implements Serializable {

    private String sourceInstitutionCode;
    private String mifValue;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String subjectCodeEquiv;
    private String courseNumberEquiv;
    private String academicPeriodStart;
    private String equivCourseAttribute;

    public String getSourceInstitutionCode() {
        return sourceInstitutionCode;
    }

    public void setSourceInstitutionCode(String sourceInstitutionCode) {
        this.sourceInstitutionCode = sourceInstitutionCode;
    }

    public String getMifValue() {
        return mifValue;
    }

    public void setMifValue(String mifValue) {
        this.mifValue = mifValue;
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

    public String getSubjectCodeEquiv() {
        return subjectCodeEquiv;
    }

    public void setSubjectCodeEquiv(String subjectCodeEquiv) {
        this.subjectCodeEquiv = subjectCodeEquiv;
    }

    public String getCourseNumberEquiv() {
        return courseNumberEquiv;
    }

    public void setCourseNumberEquiv(String courseNumberEquiv) {
        this.courseNumberEquiv = courseNumberEquiv;
    }

    public String getAcademicPeriodStart() {
        return academicPeriodStart;
    }

    public void setAcademicPeriodStart(String academicPeriodStart) {
        this.academicPeriodStart = academicPeriodStart;
    }

    public String getEquivCourseAttribute() {
        return equivCourseAttribute;
    }

    public void setEquivCourseAttribute(String equivCourseAttribute) {
        this.equivCourseAttribute = equivCourseAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CourseId courseId = (CourseId) o;

        if (sourceInstitutionCode != null ? !sourceInstitutionCode.equals(courseId.sourceInstitutionCode) : courseId.sourceInstitutionCode != null)
            return false;
        if (mifValue != null ? !mifValue.equals(courseId.mifValue) : courseId.mifValue != null)
            return false;
        if (subjectCodeTrans != null ? !subjectCodeTrans.equals(courseId.subjectCodeTrans) : courseId.subjectCodeTrans != null)
            return false;
        if (courseNumberTrans != null ? !courseNumberTrans.equals(courseId.courseNumberTrans) : courseId.courseNumberTrans != null)
            return false;
        if (subjectCodeEquiv != null ? !subjectCodeEquiv.equals(courseId.subjectCodeEquiv) : courseId.subjectCodeEquiv != null)
            return false;
        if (courseNumberEquiv != null ? !courseNumberEquiv.equals(courseId.courseNumberEquiv) : courseId.courseNumberEquiv != null)
            return false;
        if (academicPeriodStart != null ? !academicPeriodStart.equals(courseId.academicPeriodStart) : courseId.academicPeriodStart != null)
            return false;
        return equivCourseAttribute != null ? equivCourseAttribute.equals(courseId.equivCourseAttribute) : courseId.equivCourseAttribute == null;
    }

    @Override
    public int hashCode() {
        int result = sourceInstitutionCode != null ? sourceInstitutionCode.hashCode() : 0;
        result = 31 * result + (mifValue != null ? mifValue.hashCode() : 0);
        result = 31 * result + (subjectCodeTrans != null ? subjectCodeTrans.hashCode() : 0);
        result = 31 * result + (courseNumberTrans != null ? courseNumberTrans.hashCode() : 0);
        result = 31 * result + (subjectCodeEquiv != null ? subjectCodeEquiv.hashCode() : 0);
        result = 31 * result + (courseNumberEquiv != null ? courseNumberEquiv.hashCode() : 0);
        result = 31 * result + (academicPeriodStart != null ? academicPeriodStart.hashCode() : 0);
        result = 31 * result + (equivCourseAttribute != null ? equivCourseAttribute.hashCode() : 0);
        return result;
    }
}
