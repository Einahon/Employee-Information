package com.eliehome.EmployeeInformation.controller;

import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);

    }
    @GetMapping("/employees")
    public List<Employee> getEmployeeList() {
        return employeeService.listOfEmployees();
    }

}
