package edu.hawaii.its.creditxfer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.hawaii.its.creditxfer.type.Action;

public interface ActionRepository extends JpaRepository<Action, Integer> {

    Action findById(Long id);

    List<Action> findAllByOrderById();
}
