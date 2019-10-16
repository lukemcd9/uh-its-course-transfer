package edu.hawaii.its.creditxfer.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import edu.hawaii.its.creditxfer.type.Institution;
import edu.hawaii.its.creditxfer.type.Institution_;

public class InstitutionSpecification {

    // Constructor
    private InstitutionSpecification() {
        // Empty
    }

    public static Specification<Institution> excludeCity(String city) {
        return new Specification<Institution>() {
            @Override
            public Predicate toPredicate(Root<Institution> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.notLike(criteriaBuilder.lower(root.get(Institution_.city)), city.toLowerCase());
                return predicate;
            }
        };
    }

    public static Specification<Institution> excludeDescription(String description) {
        return new Specification<Institution>() {
            @Override
            public Predicate toPredicate(Root<Institution> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.notLike(criteriaBuilder.lower(root.get(Institution_.description)), ("%" + description + "%").toLowerCase());
                return predicate;
            }
        };
    }

    public static Specification<Institution> exclude(String string) {
        return Specification.where(excludeCity(string)).and(excludeDescription(string));
    }

}
