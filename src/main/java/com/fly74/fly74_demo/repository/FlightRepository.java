package com.fly74.fly74_demo.repository;

import com.fly74.fly74_demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}