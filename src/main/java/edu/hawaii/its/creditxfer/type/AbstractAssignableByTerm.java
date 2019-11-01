package edu.hawaii.its.creditxfer.type;

public class AbstractAssignableByTerm {

    protected Term effectiveTerm;
    protected Term endTerm;

    protected AbstractAssignableByTerm(Term effectiveTerm, Term endTerm) {
        this.effectiveTerm = effectiveTerm;
        this.endTerm = endTerm;
    }

    public Term getEffectiveTerm() {
        return effectiveTerm;
    }

    public Term getEndTerm() {
        return endTerm;
    }

    public int compareTo(AbstractAssignableByTerm that) {
        if (this == that) {
            return 0;
        }

        int i = this.endTerm.getTermCode().compareTo(that.endTerm.getTermCode());
        if (i != 0) {
            return -i;
        }

        i = this.effectiveTerm.getTermCode().compareTo(that.effectiveTerm.getTermCode());
        if (i != 0) {
            return -i;
        }

        return 0;
    }

}