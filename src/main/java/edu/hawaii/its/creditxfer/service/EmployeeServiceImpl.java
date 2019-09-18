package edu.hawaii.its.creditxfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.creditxfer.repository.EmployeeRepository;

@Service("employeeService")
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