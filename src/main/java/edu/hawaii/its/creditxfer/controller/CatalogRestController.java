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
import edu.hawaii.its.creditxfer.type.CatalogDto;
import edu.hawaii.its.creditxfer.type.SourceCatalog;
import edu.hawaii.its.creditxfer.type.TargetCatalog;

@RestController
public class CatalogRestController {

    private static final Log logger = LogFactory.getLog(InstitutionRestController.class);

    @Autowired
    private CatalogService catalogService;

    @GetMapping(value = "/api/sourceCatalog")
    public ResponseEntity<List<SourceCatalog>> sourceCatalog() {
        logger.info("Entered REST catalog...");
        List<SourceCatalog> catalog = catalogService.findAllSourceCatalog();
        return ResponseEntity
            .ok()
            .body(catalog);
    }

    @GetMapping(value = "/api/targetCatalog")
    public ResponseEntity<List<TargetCatalog>> targetCatalog() {
        logger.info("Entered REST target catalog...");
        List<TargetCatalog> catalog = catalogService.findAllTargetCatalog();
        return ResponseEntity
            .ok()
            .body(catalog);
    }


    @GetMapping(value = "/api/catalog/source/{source}/target/{target}")
    public ResponseEntity<List<CatalogDto>> catalogBySourceAndTarget(
        @PathVariable String source,
        @PathVariable String target) {
        logger.info("Entered REST catalog (source=" + source + ", target=" + target +")...");
        List<CatalogDto> catalog = catalogService.findAllBySourceAndTarget(source, target);
        return ResponseEntity
            .ok()
            .body(catalog);
    }
}
