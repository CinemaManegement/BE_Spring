package com.example.be_spring.repository.room;

import com.example.be_spring.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepo extends JpaRepository<Room, Integer> {
}
