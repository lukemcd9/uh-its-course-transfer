package edu.hawaii.its.creditxfer.service;

import static edu.hawaii.its.creditxfer.repository.specification.InstitutionSpecification.exclude;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.repository.InstitutionRepository;
import edu.hawaii.its.creditxfer.type.Institution;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Transactional(readOnly = true)
    public List<Institution> findInstitution(String code) {
        return institutionRepository.findAllByCode(code).get();
    }

    public List<Institution> findAllInstitutionsByState(String state) {
        return institutionRepository.findAllByStateProvince(state);
    }

    @Cacheable(value = "institutions")
    public List<Institution> findAll() {
        return institutionRepository.findAll(exclude("Do Not Use"));
    }
}
