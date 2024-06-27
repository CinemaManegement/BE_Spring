package com.example.spring_cinema.controller;

import com.example.spring_cinema.dto.Seat.SeatProjection;
import com.example.spring_cinema.service.seat.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/seat")
public class SeatController {
    @Autowired
    ISeatService iSeatService;
    @GetMapping("/purchased-seats/{id}")
    public ResponseEntity<List<SeatProjection>> listSeatProjection(@PathVariable int id) {
        List<SeatProjection> seatProjectionList = iSeatService.listSeatProjection(id);
        if(seatProjectionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(seatProjectionList,HttpStatus.OK);
    }
}
