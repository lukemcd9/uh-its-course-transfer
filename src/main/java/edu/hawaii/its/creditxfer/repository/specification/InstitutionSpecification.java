package edu.hawaii.its.creditxfer.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import edu.hawaii.its.creditxfer.type.Institution;
import edu.hawaii.its.creditxfer.type.Institution_;

public class InstitutionSpecification {

    private InstitutionSpecification() {
        // Empty Constructor
    }

    public static Specification<Institution> excludeCity(String city) {
        return (Specification<Institution>) (root, query, builder) ->
            builder.notLike(builder.lower(root.get(Institution_.city)), city.toLowerCase());
    }

}
