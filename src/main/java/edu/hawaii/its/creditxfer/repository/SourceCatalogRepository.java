package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.hawaii.its.creditxfer.type.SourceCatalog;
import edu.hawaii.its.creditxfer.type.CatalogDto;

public interface SourceCatalogRepository
    extends JpaRepository<SourceCatalog, Integer> {

    List<SourceCatalog> findAllByOrderBySourceInstitutionCode();

    @Query("select new edu.hawaii.its.creditxfer.type.CatalogDto(s.sourceInstitutionCode, s.mifValue, s.academicPeriodStart, " +
        "s.subjectCodeTrans, s.courseNumberTrans, s.courseTitleTrans, " +
        "t.subjectCodeEquiv, t.courseNumberEquiv, t.courseTitleEquiv, " +
        "t.equivCreditsUsed, t.sequenceNumber, t.connector) " +
        "from SourceCatalog s inner join TargetCatalog t " +
        "on s.subjectCodeTrans = t.subjectCodeTrans and s.courseNumberTrans = t.courseNumberTrans and " +
        "s.academicPeriodStart = t.academicPeriodStart and s.sourceInstitutionCode = t.sourceInstitutionCode and " +
        "s.mifValue = t.mifValue " +
        "where s.sourceInstitutionCode = :sourceInstitutionCode and s.mifValue = :mifValue")
    List<CatalogDto> findAllBySourceAndTarget(@Param("sourceInstitutionCode") String sourceInstitutionCode, @Param("mifValue") String mifValue);
}
