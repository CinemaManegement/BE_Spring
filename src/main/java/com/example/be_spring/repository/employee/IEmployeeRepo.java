package com.example.be_spring.repository.employee;


import com.example.be_spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
}
