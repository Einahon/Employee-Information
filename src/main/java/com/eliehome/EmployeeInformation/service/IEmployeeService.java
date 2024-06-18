package com.eliehome.EmployeeInformation.service;

import com.eliehome.EmployeeInformation.error.EmployeeNotFoundException;
import com.eliehome.EmployeeInformation.model.Employee;

import java.util.List;

public interface IEmployeeService {
   public Employee saveEmployee(Employee employee);

  public List<Employee> fetchEmployeeList();

   public Employee fetchEmployeeById(Long employee_id) throws EmployeeNotFoundException;

   public void deleteEmployeeById(Long employee_id) throws EmployeeNotFoundException;


   public Employee updateEmployee(Long employee_id, Employee employee) throws EmployeeNotFoundException;

   public Employee fetchEmployeeByTitle(String jobTitle);
}
