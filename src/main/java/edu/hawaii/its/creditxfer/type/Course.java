package edu.hawaii.its.creditxfer.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MST_COURSE_ATTRIBUTE")
@IdClass(CourseId.class)
public class Course {

    public static final long serialVersionUID = 2L;

    private String attribute;
    private String start;
    private String startDescription;
    private String end;
    private String endDescription;
    private String mifValue;
    private String subject;
    private String courseNumber;

    @Id
    @Column(name = "COURSE_ATTRIBUTE")
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Id
    @Column(name = "ACADEMIC_PERIOD_START")
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Column(name = "ACADEMIC_PERIOD_START_DESC")
    public String getStartDescription() {
        return startDescription;
    }

    public void setStartDescription(String startDescription) {
        this.startDescription = startDescription;
    }

    @Column(name = "ACADEMIC_PERIOD_END")
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Column(name = "ACADEMIC_PERIOD_END_DESC")
    public String getEndDescription() {
        return endDescription;
    }

    public void setEndDescription(String endDescription) {
        this.endDescription = endDescription;
    }

    @Id
    @Column(name = "MIF_VALUE")
    public String getMifValue() {
        return mifValue;
    }

    public void setMifValue(String mifValue) {
        this.mifValue = mifValue;
    }

    @Id
    @Column(name = "SUBJECT")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Id
    @Column(name = "COURSE_NUMBER")
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }
}
