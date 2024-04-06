package com.eliehome.EmployeeInformation.service;

import com.eliehome.EmployeeInformation.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
   public Employee saveEmployee(Employee employee);

  public List<Employee> listOfEmployees();

   public Employee getEmployeeById(Long employeeId);

   public void deleteEmployeeById(Long employeeId);


//   public Employee updateEmployeeById(Long employeeId, Employee employee);
}
