package com.fly74.fly74_demo.repository;

import com.fly74.fly74_demo.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}