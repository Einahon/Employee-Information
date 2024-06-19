package com.eliehome.EmployeeInformation.service.impl;

import com.eliehome.EmployeeInformation.error.EmployeeNotFoundException;
import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.repository.EmployeeRepository;
import com.eliehome.EmployeeInformation.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {return    employeeRepository.save(employee);}
    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee fetchEmployeeById(Long employee_id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employee_id);
        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Available");
        }
        return employee.get();
    }
    @Override
    public void deleteEmployeeById(Long employee_id) throws EmployeeNotFoundException {
        if(!employeeRepository.existsById(employee_id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + employee_id);
        }
        employeeRepository.deleteById(employee_id);
    }

    @Override
    public Employee updateEmployee(Long employee_id, Employee employee) throws EmployeeNotFoundException {
        Employee employee1 = employeeRepository.findById(employee_id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: "+ employee_id));

            if (employee.getFirst_name() != null) {
                employee1.setFirst_name(employee.getFirst_name());
            }
            else
                throw new EmployeeNotFoundException("Employee First Name must not be empty");
            if (employee.getLast_name() != null) {
                employee1.setLast_name(employee.getLast_name());
            } else
                throw new EmployeeNotFoundException("Employee Last Name must not be empty");
            if (employee.getPhone_number()!= null) {
                employee1.setPhone_number(employee.getPhone_number());
            }else{
                throw new EmployeeNotFoundException("Employee Phone Number required");}
            if(employee.getTitle() != null){
                employee1.setTitle(employee.getTitle());
            }else {
                throw new EmployeeNotFoundException("Employee with this job title not found" );
            }
        return employeeRepository.save(employee1);
    }

    @Override
    public Employee fetchEmployeeByTitle(String title) {
        Employee employee = employeeRepository.findByTitle(title);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee Not Available by Job_Title "+ title);
        }
        return employee;
    }
}





