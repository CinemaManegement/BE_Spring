package com.example.be_spring.repository.schedule;

import com.example.be_spring.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleRepo extends JpaRepository<Schedule, Integer> {
}
