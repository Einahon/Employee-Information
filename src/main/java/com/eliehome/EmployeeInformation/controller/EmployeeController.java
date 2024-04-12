package com.eliehome.EmployeeInformation.controller;

import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);

    }
    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList() {

        return employeeService.fetchEmployeeList();
    }
    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employee_Id){
            return employeeService.fetchEmployeeById(employee_Id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employee_Id){
         employeeService.deleteEmployeeById(employee_Id);
         return "Employee Deleted Successfully!!";

    }


}
