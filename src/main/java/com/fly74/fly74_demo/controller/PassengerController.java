package com.fly74.fly74_demo.controller;

import com.fly74.fly74_demo.model.Flight;
import com.fly74.fly74_demo.model.Passenger;
import com.fly74.fly74_demo.repository.FlightRepository;
import com.fly74.fly74_demo.repository.PassengerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
@CrossOrigin(origins = "*")
public class PassengerController {

    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;

    public PassengerController(PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
    }

    @PostMapping("/flight/{flightId}")
    public Passenger createPassenger(@PathVariable Long flightId, @RequestBody Passenger passenger) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        passenger.setFlight(flight);
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passengerDetails) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));

        passenger.setFullName(passengerDetails.getFullName());
        passenger.setDocumentNumber(passengerDetails.getDocumentNumber());

        return passengerRepository.save(passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerRepository.deleteById(id);
    }
}