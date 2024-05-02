package com.eliehome.EmployeeInformation.controller;

import com.eliehome.EmployeeInformation.error.EmployeeNotFoundException;
import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        LOGGER.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);

    }
    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList() {
     LOGGER.info("Inside fetchEmployeeList of EmployeeController");
        return employeeService.fetchEmployeeList();
    }
    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        LOGGER.info("Inside fetchEmployeeById of EmployeeController ");
            return employeeService.fetchEmployeeById(employeeId);
    }
    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        LOGGER.info("Inside deleteEmployeeById of EmployeeController ");
         employeeService.deleteEmployeeById(employeeId);
         return "Employee Deleted Successfully!!";
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Long employeeId,@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
        return employeeService.updateEmployee(employeeId, employee);
    }
    @GetMapping("/employees/name/{name}")
    public Employee fetchByEmployeeName(@PathVariable("name") String employeeName) throws EmployeeNotFoundException {
        return employeeService.fetchByEmployeeName(employeeName);

    }

    }

