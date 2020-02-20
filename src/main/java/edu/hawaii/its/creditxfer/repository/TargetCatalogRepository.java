package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hawaii.its.creditxfer.type.TargetCatalog;

public interface TargetCatalogRepository extends JpaRepository<TargetCatalog, Integer> {

    List<TargetCatalog> findAllByOrderBySourceInstitutionCode();
}
