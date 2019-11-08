package edu.hawaii.its.creditxfer.type;

public class Term {

    public static final String BEGINING_OF_TIME = "000000";
    public static final String END_OF_TIME = "999999";
    private String termCode;
    private String termDescription;

    public Term(String termCode, String termDescription) {
        this.termCode = termCode;
        this.termDescription = termDescription;
    }

    public String getTermCode() {
        return termCode;
    }

    public String getTermDescription() {
        if (this.termCode.equals(BEGINING_OF_TIME)) {
            return "\u221e";
        }
        else if (this.termCode.equals(END_OF_TIME)) {
            return "present";
        }
        else {
            return termDescription;
        }
    }

    public String getShortName() {
        if (this.termCode.equals(BEGINING_OF_TIME)) {
            return "\u221e"; // "infinity" symbol
        }
        else if (this.termCode.equals(END_OF_TIME)) {
            return "present";
        }
        else {
            return termAbbrev(termCode.charAt(4)) + extractYear(termCode);
        }
    }

    public static String extractYear(String termCode) {
        String baseYear = termCode.substring(0, 4);
        char term = termCode.charAt(4);
        if (term == '0' || term == '1' || term == '2') {
            return Integer.toString(Integer.parseInt(baseYear) - 1);
        }
        return baseYear;
    }

    public static String termAbbrev(char c) {

        switch (c) {

            case '0':
                return ""; // this apparently means "the whole year"

            case '1':
                return "F/";

            case '2':
                return "W/";

            case '3':
                return "Sp/";

            case '4':
                return "Su/";

            default:
                return "?/";
        }
    }

    public String toString() {
        return "Term ["
            + "code: " + termCode + "; "
            + "description: " + termDescription + "]";
    }
}