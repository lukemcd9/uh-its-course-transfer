package edu.hawaii.its.creditxfer.type;

import edu.hawaii.its.creditxfer.type.AbstractAssignableByTerm;

/**
 * the 'assignment' of an attribute to a course.  i.e., the thing
 * assigned in the SCADETL Banner form.
 *
 */
public class CourseAttributeAssignment
    extends AbstractAssignableByTerm
    implements Comparable<CourseAttributeAssignment> {

    private CourseAttribute attribute;

    public CourseAttributeAssignment(CourseAttribute ca, Term start, Term end) {
        super(start, end);
        this.attribute = ca;
    }

    public CourseAttribute getAttribute() {
        return attribute;
    }

    public int compareTo(CourseAttributeAssignment that) {
        int v = super.compareTo(that);
        if (v != 0) {
            return v;
        }
        return this.attribute.name().compareTo(that.attribute.name());
    }

    @Override
    public String toString() {
        return "CourseAttributeAssignment [attribute: " + attribute + "]";
    }
}