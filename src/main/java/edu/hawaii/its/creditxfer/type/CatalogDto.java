package edu.hawaii.its.creditxfer.type;

public class CatalogDto {

    private String sourceInstitutionCode;
    private String mifValue;
    private String academicPeriodStart;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String courseTitleTrans;
    private String subjectCodeEquiv;
    private String courseNumberEquiv;
    private String courseTitleEquiv;
    private Integer equivCreditsUsed;
    private Integer sequenceNumber;
    private String connector;

    public CatalogDto() {
        // Empty
    }

    public CatalogDto(String sourceInstitutionCode, String mifValue, String academicPeriodStart,
        String subjectCodeTrans, String courseNumberTrans, String courseTitleTrans,
        String subjectCodeEquiv, String courseNumberEquiv, String courseTitleEquiv,
        Integer equivCreditsUsed, Integer sequenceNumber, String connector) {
        this.sourceInstitutionCode = sourceInstitutionCode;
        this.mifValue = mifValue;
        this.academicPeriodStart = academicPeriodStart;
        this.subjectCodeTrans = subjectCodeTrans;
        this.courseNumberTrans = courseNumberTrans;
        this.courseTitleTrans = courseTitleTrans;
        this.subjectCodeEquiv = subjectCodeEquiv;
        this.courseNumberEquiv = courseNumberEquiv;
        this.courseTitleEquiv = courseTitleEquiv;
        this.equivCreditsUsed = equivCreditsUsed;
        this.sequenceNumber = sequenceNumber;
        this.connector = connector;
    }

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

    public String getAcademicPeriodStart() {
        return academicPeriodStart;
    }

    public void setAcademicPeriodStart(String academicPeriodStart) {
        this.academicPeriodStart = academicPeriodStart;
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

    public String getCourseTitleTrans() {
        return courseTitleTrans;
    }

    public void setCourseTitleTrans(String courseTitleTrans) {
        this.courseTitleTrans = courseTitleTrans;
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

    public String getCourseTitleEquiv() {
        return courseTitleEquiv;
    }

    public void setCourseTitleEquiv(String courseTitleEquiv) {
        this.courseTitleEquiv = courseTitleEquiv;
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

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    @Override
    public String toString() {
        return "CatalogDto [" +
            "sourceInstitutionCode=" + sourceInstitutionCode
            + ", mifValue=" + mifValue
            + ", academicPeriodStart=" + academicPeriodStart
            + ", subjectCodeTrans=" + subjectCodeTrans
            + ", courseNumberTrans=" + courseNumberTrans
            + ", courseTitleTrans=" + courseTitleTrans
            + ", subjectCodeEquiv=" + subjectCodeEquiv
            + ", courseNumberEquiv=" + courseNumberEquiv
            + ", courseTitlteEquiv=" + courseTitleEquiv
            + ", equivCreditsUsed=" + equivCreditsUsed
            + ", sequenceNumber=" + sequenceNumber
            + ", connector=" + connector
            + "]";
    }
}
