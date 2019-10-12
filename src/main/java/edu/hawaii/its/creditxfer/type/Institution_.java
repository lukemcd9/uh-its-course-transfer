package edu.hawaii.its.creditxfer.type;

import javax.persistence.metamodel.SingularAttribute;

public class Institution_ {

    private Institution_() {
        //Empty constructor
    }

    public static volatile SingularAttribute<Institution, String> code;
    public static volatile SingularAttribute<Institution, String> description;
    public static volatile SingularAttribute<Institution, String> city;
    public static volatile SingularAttribute<Institution, String> stateProvince;

}
