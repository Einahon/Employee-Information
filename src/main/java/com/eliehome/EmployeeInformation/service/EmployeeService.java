package com.eliehome.EmployeeInformation.service;

import com.eliehome.EmployeeInformation.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
   public Employee saveEmployee(Employee employee);

  public List<Employee> fetchEmployeeList();

   public Employee fetchEmployeeById(Long employeeId);

   public void deleteEmployeeById(Long employeeId);




//   public Employee updateEmployeeById(Long employeeId, Employee employee);
}
