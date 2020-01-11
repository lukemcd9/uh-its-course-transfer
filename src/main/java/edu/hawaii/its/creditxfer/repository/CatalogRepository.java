package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.hawaii.its.creditxfer.type.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

    List<Catalog> findAllByOrderBySourceInstitutionCode();

    @Query("select c from Catalog c where c.sourceInstitutionCode = :sourceInstitutionCode and c.mifValue = :mifValue")
    List<Catalog> findAllBySourceAndTarget(@Param("sourceInstitutionCode") String sourceInstitutionCode, @Param("mifValue") String mifValue);
}
