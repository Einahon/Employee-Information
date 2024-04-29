package com.eliehome.EmployeeInformation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    @NotBlank(message="Please add Employee Name")
    @Length(max = 100, min = 1)
    private String employeeName;
    @Length(max = 12, min = 0)
    private String employeePhoneNumber;
    @Length(max = 25, min = 0)
    private String employeeDepartment;



}
