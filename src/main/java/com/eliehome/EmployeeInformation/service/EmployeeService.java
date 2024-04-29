package com.eliehome.EmployeeInformation.service;

import com.eliehome.EmployeeInformation.error.EmployeeNotFoundException;
import com.eliehome.EmployeeInformation.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
   public Employee saveEmployee(Employee employee);

  public List<Employee> fetchEmployeeList();

   public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;

   public void deleteEmployeeById(Long employeeId) throws EmployeeNotFoundException;


   public Employee updateEmployee(Long employeeId, Employee employee);

   public Employee fetchByEmployeeName(String employeeName);
}
