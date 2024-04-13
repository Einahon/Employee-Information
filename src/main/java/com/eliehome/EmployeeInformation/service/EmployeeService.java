package com.eliehome.EmployeeInformation.service;

import com.eliehome.EmployeeInformation.error.EmployeeNotFoundException;
import com.eliehome.EmployeeInformation.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
   public Employee saveEmployee(Employee employee);

  public List<Employee> fetchEmployeeList();

   public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;

   public void deleteEmployeeById(Long employeeId);

//   public Employee updateEmployee(Long employeeId, Employee employee);




//   public Employee updateEmployeeById(Long employeeId, Employee employee);
}
