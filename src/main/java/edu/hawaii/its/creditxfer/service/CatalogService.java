package edu.hawaii.its.creditxfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hawaii.its.creditxfer.repository.CatalogRepository;
import edu.hawaii.its.creditxfer.type.Catalog;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public List<Catalog> findAll() {
        return catalogRepository.findAllByOrderByMifValue();
    }
}
