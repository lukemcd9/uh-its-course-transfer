package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.repository.InstitutionRepository;
import edu.hawaii.its.creditxfer.type.Institution;

@Repository("institutionService")
public class InstitutionServiceImpl implements InstitutionService{

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    @Transactional(readOnly = true)
    public Institution findInstitution(String code) { return institutionRepository.findByCode(code).get();}

    @Override
    public List<Institution> findAllInstitutionsByState(String state) { return institutionRepository.findAllByStateProvince(state);}
}
