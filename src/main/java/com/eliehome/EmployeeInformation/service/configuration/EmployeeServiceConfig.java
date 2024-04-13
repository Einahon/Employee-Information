package com.eliehome.EmployeeInformation.service.configuration;

import com.eliehome.EmployeeInformation.error.EmployeeNotFoundException;
import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.repository.EmployeeRepository;
import com.eliehome.EmployeeInformation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceConfig implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(!employee.isPresent()){
            throw new EmployeeNotFoundException("Employee Not Available");
        }
        return employee.get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {employeeRepository.deleteById(employeeId);
    }



}
