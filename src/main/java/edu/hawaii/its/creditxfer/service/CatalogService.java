package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.hawaii.its.creditxfer.repository.SourceCatalogRepository;
import edu.hawaii.its.creditxfer.repository.TargetCatalogRepository;
import edu.hawaii.its.creditxfer.type.CatalogDto;
import edu.hawaii.its.creditxfer.type.SourceCatalog;
import edu.hawaii.its.creditxfer.type.TargetCatalog;

@Service
public class CatalogService {

    @Autowired
    private SourceCatalogRepository sourceCatalogRepository;

    @Autowired
    private TargetCatalogRepository targetCatalogRepository;

    public List<SourceCatalog> findAllSourceCatalog() {
        return sourceCatalogRepository.findAllByOrderBySourceInstitutionCode();
    }

    public List<TargetCatalog> findAllTargetCatalog() {
        return targetCatalogRepository.findAllByOrderBySourceInstitutionCode();
    }

    public List<CatalogDto> findAllBySourceAndTarget(String sourceInstitutionCode, String mifValue) {
        return sourceCatalogRepository.findAllBySourceAndTarget(sourceInstitutionCode, mifValue);
    }
}
