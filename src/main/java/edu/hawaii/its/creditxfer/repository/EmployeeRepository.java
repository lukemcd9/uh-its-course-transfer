package edu.hawaii.its.creditxfer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.hawaii.its.creditxfer.type.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Override
    Optional<Employee> findById(Integer id);

    @Query("select e from Employee e where e.uhNumber = :uhNumber")
    Optional<Employee> findByUhNumber(@Param("uhNumber") Long id);
}
