package com.eliehome.EmployeeInformation.service;

import com.eliehome.EmployeeInformation.model.Employee;

import java.util.List;

public interface EmployeeService {
   public Employee saveEmployee(Employee employee);

  public List<Employee> listOfEmployees();
}
