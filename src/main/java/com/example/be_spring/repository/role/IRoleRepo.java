package com.example.be_spring.repository.role;

import com.example.be_spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role, Integer> {
}
