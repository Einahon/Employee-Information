package com.eliehome.EmployeeInformation.service.configuration;

import com.eliehome.EmployeeInformation.error.EmployeeNotFoundException;
import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.repository.EmployeeRepository;
import com.eliehome.EmployeeInformation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException("Employee Not Available");
        }
        return employee.get();
    }
    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee)  {
        Employee employee1 = employeeRepository.findById(employeeId).get();
        if(employee.getEmployeeDepartment()!= null){
            employee1.setEmployeeDepartment(employee.getEmployeeDepartment());
        }
        if(employee.getEmployeeName()!= null) {
            employee1.setEmployeeName(employee.getEmployeeName());
        }
        if(employee.getEmployeePhoneNumber()!= null){
            employee1.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
        }
        return employeeRepository.save(employee1);
    }

    @Override
    public Employee fetchByEmployeeName(String employeeName) {
        return employeeRepository.findByEmployeeNameIgnoreCase(employeeName);
    }
}





