package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hawaii.its.creditxfer.type.Action;

public interface ActionRepository extends JpaRepository<Action, Integer> {

    Action findById(Long id);

    List<Action> findAllByOrderById();
}
