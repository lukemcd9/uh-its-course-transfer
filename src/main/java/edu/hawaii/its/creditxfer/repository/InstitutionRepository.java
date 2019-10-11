package edu.hawaii.its.creditxfer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.hawaii.its.creditxfer.type.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {

    @Query("select i from Institution i where i.city <> 'DO NOT USE' and i.city <> 'Do Not Use'")
    List<Institution> findAll();

    Optional<Institution> findByCode(String code);

    List<Institution> findAllByStateProvince(String state);
}
