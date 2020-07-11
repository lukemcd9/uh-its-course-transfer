package edu.hawaii.its.creditxfer.controller;

import javax.annotation.PostConstruct;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hawaii.its.creditxfer.service.InstitutionService;
import edu.hawaii.its.creditxfer.type.Institution;


@RestController
public class InstitutionRestController {

    private static final Log logger = LogFactory.getLog(InstitutionRestController.class);

    @Autowired
    private InstitutionService institutionService;

    @PostConstruct
    public void init() {
        logger.debug("Caching institutions...");
        institutionService.findAll();
        logger.debug("Finished caching institutions");
    }

    @GetMapping(value = "/api/institutions")
    public ResponseEntity<List<Institution>> institutions() {
        logger.info("Entered REST institutions...");
        List<Institution> institutions = institutionService.findAll();
        return ResponseEntity
                .ok()
                .body(institutions);
    }

}