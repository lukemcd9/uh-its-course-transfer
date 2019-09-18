package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.repository.InstitutionRepository;
import edu.hawaii.its.creditxfer.type.Institution;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Transactional(readOnly = true)
    public Institution findInstitution(String code) {
        return institutionRepository.findByCode(code).get();
    }

    public List<Institution> findAllInstitutionsByState(String state) {
        return institutionRepository.findAllByStateProvince(state);
    }
}
