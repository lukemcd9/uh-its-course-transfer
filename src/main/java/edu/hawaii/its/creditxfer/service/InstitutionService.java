package edu.hawaii.its.creditxfer.service;

import java.util.List;

import edu.hawaii.its.creditxfer.type.Institution;

public interface InstitutionService {

    Institution findInstitution(String code);

    List<Institution> findAllInstitutionsByState(String state);
}
