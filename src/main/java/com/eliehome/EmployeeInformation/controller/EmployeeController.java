package com.eliehome.EmployeeInformation.controller;

import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        LOGGER.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);

    }
    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList() {
     LOGGER.info("Inside fetchEmployeeList of EmployeeController");
        return employeeService.fetchEmployeeList();
    }
    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employee_Id){
        LOGGER.info("Inside fetchEmployeeById of EmployeeController ");
            return employeeService.fetchEmployeeById(employee_Id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employee_Id){
        LOGGER.info("Inside deleteEmployeeById of EmployeeController ");
         employeeService.deleteEmployeeById(employee_Id);
         return "Employee Deleted Successfully!!";

    }


}
