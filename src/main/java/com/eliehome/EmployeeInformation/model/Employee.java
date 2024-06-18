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
    public Long employee_id;

    @NotBlank(message = "Please add First Name")
    public String first_name;

    @NotBlank(message = "Please add Last Name")
    public String last_name;

    @Length(max = 50, min = 1, message = "Must be of 1 - 25 characters")
    public String title;

    @Length(max = 12, min = 8, message = "Must be of 8 - 12 digit")
    public String phone_number;



}
