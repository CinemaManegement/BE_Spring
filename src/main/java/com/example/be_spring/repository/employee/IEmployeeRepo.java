package com.example.spring_cinema.repository.employee;

import com.example.spring_cinema.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
}
