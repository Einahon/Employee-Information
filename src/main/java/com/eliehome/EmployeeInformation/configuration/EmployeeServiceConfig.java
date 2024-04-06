package com.eliehome.EmployeeInformation.configuration;

import com.eliehome.EmployeeInformation.model.Employee;
import com.eliehome.EmployeeInformation.repository.EmployeeRepository;
import com.eliehome.EmployeeInformation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceConfig implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listOfEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }


//    @Override
//    public Employee updateEmployeeById(Long employeeId, Employee employee) {
//        Employee empDB = employeeRepository.findById(employeeId).get();
//        if(Objects.nonNull(employee.getEmployeeName()) &&
//        !"".equalsIgnoreCase(employee.getEmployeeName())){
//            empDB.setEmployeeName(employee.getEmployeeName());
//        }
//        if(Objects.nonNull(employee.getEmployeeDepartment()) &&
//                !"".equalsIgnoreCase(employee.getEmployeeDepartment())){
//            empDB.setEmployeeDepartment(employee.getEmployeeDepartment());
//        }
//        if(Objects.nonNull(employee.getEmployeePhoneNumber()) &&
//                !"".equalsIgnoreCase(employee.getEmployeePhoneNumber())){
//            empDB.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
//        }
//        return employeeRepository.save(empDB);
//    }

}
