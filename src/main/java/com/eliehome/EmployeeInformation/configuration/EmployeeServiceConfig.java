package com.eliehome.EmployeeInformation.configuration;

import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.repository.EmployeeRepository;
import com.eliehome.EmployeeInformation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class EmployeeServiceConfig implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listOfEmployees() {
        return employeeRepository.findAll();
    }

}
