package com.eliehome.EmployeeInformation.controller;

import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employee_Id){
            return employeeService.getEmployeeById(employee_Id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employee_Id){
         employeeService.deleteEmployeeById(employee_Id);
         return "Employee Deleted Successfully!!";

    }

//    @PutMapping("/employees/{id}")
//    public Employee updateEmployeeById(@PathVariable("id") Long employee_Id, @RequestBody Employee employee){
//        return employeeService.updateEmployeeById(employee_Id, employee);
//
//    }

}
