package edu.hawaii.its.creditxfer.type;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSFER_CATALOG_UH")
@IdClass(CatalogId.class)
public class Catalog {

    public static final long serialVersionUID = 2L;

    private String mifValue;
    private String sourceInstitutionCode;
    private String courseIdTrans;
    private String subjectCodeTrans;
    private String courseNumberTrans;
    private String courseTitleTrans;
    private Integer courseLowHoursTrans;
    private Integer courseHighHoursTrans;
    private String reviewInd;
    private String tastCode;
    private String transMinGradeCode;
    private String transGroupPrimaryInd;
    private String transGroupConnector;
    private String academicPeriodStart;
    private Date transCourseActivityDate;
    private Integer sequenceNumber;
    private String equivLeftParen;
    private String connector;
    private String courseIdEquiv;
    private String subjectCodeEquiv;
    private String courseNumberEquiv;
    private String courseTitleEquiv;
    private Integer equivCreditsUsed;
    private String equivRightParen;
    private Date equivCourseActivityDate;

    @Id
    @Column(name = "MIF_VALUE")
    public String getMifValue() {
        return mifValue;
    }

    public void setMifValue(String mifValue) {
        this.mifValue = mifValue;
    }

    @Id
    @Column(name = "SOURCE_INSTITUTION_CODE")
    public String getSourceInstitutionCode() {
        return sourceInstitutionCode;
    }

    public void setSourceInstitutionCode(String sourceInstitutionCode) {
        this.sourceInstitutionCode = sourceInstitutionCode;
    }

    @Id
    @Column(name = "COURSE_IDENTIFICATION_TRANS")
    public String getCourseIdTrans() {
        return courseIdTrans;
    }

    public void setCourseIdTrans(String courseIdTrans) {
        this.courseIdTrans = courseIdTrans;
    }

    @Column(name = "SUBJECT_CODE_TRANS")
    public String getSubjectCodeTrans() {
        return subjectCodeTrans;
    }

    public void setSubjectCodeTrans(String subjectCodeTrans) {
        this.subjectCodeTrans = subjectCodeTrans;
    }

    @Column(name = "COURSE_NUMBER_TRANS")
    public String getCourseNumberTrans() {
        return courseNumberTrans;
    }

    public void setCourseNumberTrans(String courseNumberTrans) {
        this.courseNumberTrans = courseNumberTrans;
    }

    @Column(name = "COURSE_TITLE_TRANS")
    public String getCourseTitleTrans() {
        return courseTitleTrans;
    }

    public void setCourseTitleTrans(String courseTitleTrans) {
        this.courseTitleTrans = courseTitleTrans;
    }

    @Column(name = "COURSE_LOW_HOURS_TRANS")
    public Integer getCourseLowHoursTrans() {
        return courseLowHoursTrans;
    }

    public void setCourseLowHoursTrans(Integer courseLowHoursTrans) {
        this.courseLowHoursTrans = courseLowHoursTrans;
    }

    @Column(name = "COURSE_HIGH_HOURS_TRANS")
    public Integer getCourseHighHoursTrans() {
        return courseHighHoursTrans;
    }

    public void setCourseHighHoursTrans(Integer courseHighHoursTrans) {
        this.courseHighHoursTrans = courseHighHoursTrans;
    }

    @Column(name = "REVIEW_IND")
    public String getReviewInd() {
        return reviewInd;
    }

    public void setReviewInd(String reviewInd) {
        this.reviewInd = reviewInd;
    }

    @Column(name = "TAST_CODE")
    public String getTastCode() {
        return tastCode;
    }

    public void setTastCode(String tastCode) {
        this.tastCode = tastCode;
    }

    @Column(name = "TRANS_MIN_GRADE_CODE")
    public String getTransMinGradeCode() {
        return transMinGradeCode;
    }

    public void setTransMinGradeCode(String transMinGradeCode) {
        this.transMinGradeCode = transMinGradeCode;
    }

    @Column(name = "TRANS_GROUP_PRIMARY_IND")
    public String getTransGroupPrimaryInd() {
        return transGroupPrimaryInd;
    }

    public void setTransGroupPrimaryInd(String transGroupPrimaryInd) {
        this.transGroupPrimaryInd = transGroupPrimaryInd;
    }

    @Column(name = "TRANS_GROUP_CONNECTOR")
    public String getTransGroupConnector() {
        return transGroupConnector;
    }

    public void setTransGroupConnector(String transGroupConnector) {
        this.transGroupConnector = transGroupConnector;
    }

    @Id
    @Column(name = "ACADEMIC_PERIOD_START")
    public String getAcademicPeriodStart() {
        return academicPeriodStart;
    }

    public void setAcademicPeriodStart(String academicPeriodStart) {
        this.academicPeriodStart = academicPeriodStart;
    }

    @Id
    @Column(name = "TRANS_COURSE_ACTIVITY_DATE")
    public Date getTransCourseActivityDate() {
        return transCourseActivityDate;
    }

    public void setTransCourseActivityDate(Date transCourseActivityDate) {
        this.transCourseActivityDate = transCourseActivityDate;
    }

    @Id
    @Column(name = "SEQUENCE_NUMBER")
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Column(name = "EQUIV_LEFT_PAREN")
    public String getEquivLeftParen() {
        return equivLeftParen;
    }

    public void setEquivLeftParen(String equivLeftParen) {
        this.equivLeftParen = equivLeftParen;
    }

    @Column(name = "CONNECTOR")
    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    @Id
    @Column(name = "COURSE_IDENTIFICATION_EQUIV")
    public String getCourseIdEquiv() {
        return courseIdEquiv;
    }

    public void setCourseIdEquiv(String courseIdEquiv) {
        this.courseIdEquiv = courseIdEquiv;
    }

    @Column(name = "SUBJECT_CODE_EQUIV")
    public String getSubjectCodeEquiv() {
        return subjectCodeEquiv;
    }

    public void setSubjectCodeEquiv(String subjectCodeEquiv) {
        this.subjectCodeEquiv = subjectCodeEquiv;
    }

    @Column(name = "COURSE_NUMBER_EQUIV")
    public String getCourseNumberEquiv() {
        return courseNumberEquiv;
    }

    public void setCourseNumberEquiv(String courseNumberEquiv) {
        this.courseNumberEquiv = courseNumberEquiv;
    }

    @Column(name = "COURSE_TITLE_EQUIV")
    public String getCourseTitleEquiv() {
        return courseTitleEquiv;
    }

    public void setCourseTitleEquiv(String courseTitleEquiv) {
        this.courseTitleEquiv = courseTitleEquiv;
    }

    @Id
    @Column(name = "EQUIV_CREDITS_USED")
    public Integer getEquivCreditsUsed() {
        return equivCreditsUsed;
    }

    public void setEquivCreditsUsed(Integer equivCreditsUsed) {
        this.equivCreditsUsed = equivCreditsUsed;
    }

    @Column(name = "EQUIV_RIGHT_PAREN")
    public String getEquivRightParen() {
        return equivRightParen;
    }

    public void setEquivRightParen(String equivRightParen) {
        this.equivRightParen = equivRightParen;
    }

    @Id
    @Column(name = "EQUIV_COURSE_ACTIVITY_DATE")
    public Date getEquivCourseActivityDate() {
        return equivCourseActivityDate;
    }

    public void setEquivCourseActivityDate(Date equivCourseActivityDate) {
        this.equivCourseActivityDate = equivCourseActivityDate;
    }

    @Override
    public String toString() {
        return "Catalog [" +
            "mifValue=" + mifValue +
            ", sourceInstitutionCode=" + sourceInstitutionCode +
            ", courseIdTrans=" + courseIdTrans +
            ", subjectCodeTrans=" + subjectCodeTrans +
            ", courseNumberTrans=" + courseNumberTrans +
            ", courseTitleTrans=" + courseTitleTrans +
            ", courseLowHoursTrans=" + courseLowHoursTrans +
            ", courseHighHoursTrans=" + courseHighHoursTrans +
            ", reviewInd=" + reviewInd +
            ", tastCode=" + tastCode +
            ", transMinGradeCode=" + transMinGradeCode +
            ", transGroupPrimaryInd=" + transGroupPrimaryInd +
            ", transGroupConnector=" + transGroupConnector +
            ", academicPeriodStart=" + academicPeriodStart +
            ", transCourseActivityDate=" + transCourseActivityDate +
            ", sequenceNumber=" + sequenceNumber +
            ", equivLeftParen=" + equivLeftParen +
            ", connector=" + connector +
            ", courseIdEquiv=" + courseIdEquiv +
            ", subjectCodeEquiv=" + subjectCodeEquiv +
            ", courseNumberEquiv=" + courseNumberEquiv +
            ", courseTitleEquiv=" + courseTitleEquiv +
            ", equivCreditsUsed=" + equivCreditsUsed +
            ", equivRightParen=" + equivRightParen +
            ", equivCourseActivityDate=" + equivCourseActivityDate +
            "]";
    }
}
