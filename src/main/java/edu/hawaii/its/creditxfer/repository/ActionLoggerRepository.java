package edu.hawaii.its.creditxfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hawaii.its.creditxfer.type.ActionLog;

public interface ActionLoggerRepository extends JpaRepository<ActionLog, Integer> {

    List<ActionLog> findAllByOrderById();
}
