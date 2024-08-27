package com.example.springpractice.demo.Controller;


import com.example.springpractice.demo.Service.EmployeeService;
import com.example.springpractice.demo.model.Employeemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

//    @Autowired
//    Employeemodel employeemodel;

    @PostMapping("/employees")
    public ResponseEntity<?> register(@RequestBody Employeemodel employeemodel){
        return new ResponseEntity<>(employeeService.createEmployee(employeemodel), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> employeedetails(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<?>> allemployee(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Employeemodel employeemodel){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeemodel));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
