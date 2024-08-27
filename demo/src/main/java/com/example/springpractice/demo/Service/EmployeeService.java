package com.example.springpractice.demo.Service;


import com.example.springpractice.demo.Repository.EmployeeRepository;
import com.example.springpractice.demo.model.Employeemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

//    @Autowired
//    Employeemodel employeeModel;

    public Employeemodel createEmployee(Employeemodel employeemodel){
            return employeeRepository.save(employeemodel);
    }
    public Employeemodel getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employeemodel> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employeemodel updateEmployee(Long id,Employeemodel employeemodel){

        Employeemodel userById=employeeRepository.findById(id).orElse(null);
        if(employeemodel.getFirstName()!=null){
            userById.setFirstName(employeemodel.getFirstName());
        }
        if(employeemodel.getLastName()!=null){
            userById.setLastName(employeemodel.getLastName());
        }
        if(employeemodel.getDepartment()!=null){
            userById.setDepartment(employeemodel.getDepartment());
        }
        if(employeemodel.getSalary()!=null){
            userById.setSalary(employeemodel.getSalary());
        }
        return employeeRepository.save(userById);
    }

    public String deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return "Employee details with id "+id+" are successfully deleted";
    }
}
