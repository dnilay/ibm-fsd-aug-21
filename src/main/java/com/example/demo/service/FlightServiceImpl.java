package com.example.demo.service;

import com.example.demo.model.Flight;
import com.example.demo.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService{
    private FlightRepository flightRepository;
    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }
}
