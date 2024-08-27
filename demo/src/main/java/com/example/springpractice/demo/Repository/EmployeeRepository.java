package com.example.springpractice.demo.Repository;

import com.example.springpractice.demo.model.Employeemodel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employeemodel,Long> {
    Employeemodel findByFirstName(String firstName);
}
