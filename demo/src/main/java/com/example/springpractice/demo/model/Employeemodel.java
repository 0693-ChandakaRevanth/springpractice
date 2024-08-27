package com.example.springpractice.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class Employeemodel {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String department;
    private Long salary;
}
