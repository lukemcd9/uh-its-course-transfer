package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hawaii.its.creditxfer.type.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

    List<Catalog> findAllByOrderByMifValue();

}
