package com.eliehome.EmployeeInformation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Valid
    @NotBlank(message = "Please add name")
    @NotNull(message = "Please add name")
    private String employeeName;
    @Length(max = 12, min = 8, message = "Must be of 8 - 12 digit")
    private String employeePhoneNumber;
    @Length(max = 25, min = 1, message = "Must be of 1 - 25 characters")
    private String employeeDepartment;



}
