package edu.hawaii.its.creditxfer.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.hawaii.its.creditxfer.service.CatalogService;
import edu.hawaii.its.creditxfer.type.Catalog;

@RestController
public class CatalogRestController {

    private static final Log logger = LogFactory.getLog(InstitutionRestController.class);

    @Autowired
    private CatalogService catalogService;

    @GetMapping(value = "/api/catalog")
    public ResponseEntity<List<Catalog>> catalog() {
        logger.info("Entered REST catalog...");
        List<Catalog> catalog = catalogService.findAll();
        return ResponseEntity
            .ok()
            .body(catalog);
    }

    @GetMapping(value = "/api/catalog/source/{source}/target/{target}")
    public ResponseEntity<List<Catalog>> catalogByParams(
        @PathVariable String source,
        @PathVariable String target) {
        logger.info("Entered REST catalog (source=" + source + ", target=" + target +")...");
        List<Catalog> catalog = catalogService.findAllBySourceAndTarget(source, target);
        return ResponseEntity
            .ok()
            .body(catalog);
    }
}
