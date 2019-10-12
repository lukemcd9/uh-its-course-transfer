package edu.hawaii.its.creditxfer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.hawaii.its.creditxfer.type.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {

    List<Institution> findAll(Specification<Institution> specification);

    Optional<Institution> findByCode(String code);

    List<Institution> findAllByStateProvince(String state);
}
