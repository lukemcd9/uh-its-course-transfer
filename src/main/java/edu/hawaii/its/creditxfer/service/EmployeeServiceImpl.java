package edu.hawaii.its.creditxfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.repository.EmployeeRepository;

/**
 * A JPA-based implementation of the Employee Service. Delegates to a JPA entity
 * manager to issue data access calls against the backing repository. The
 * EntityManager reference is provided by the managing container (Spring)
 * automatically.
 */
@Service("employeeService")
@Repository
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean exists(String s) {
        if (!isValid(s)) {
            return false;
        }

        Long uhId = Long.valueOf(s);
        return employeeRepository.findByUhNumber(uhId).isPresent();
    }

    private boolean isValid(String str) {
        return str != null && str.matches("\\d+");
    }
}