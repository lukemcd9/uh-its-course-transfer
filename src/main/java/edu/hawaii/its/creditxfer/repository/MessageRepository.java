package edu.hawaii.its.creditxfer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hawaii.its.creditxfer.type.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Override
    Optional<Message> findById(Integer id);
}
