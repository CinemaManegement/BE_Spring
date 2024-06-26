package com.example.be_spring.repository.seat;

import com.example.be_spring.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeatRepo extends JpaRepository<Seat, Integer> {
}
