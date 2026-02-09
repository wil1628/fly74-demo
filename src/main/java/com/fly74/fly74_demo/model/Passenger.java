package com.fly74.fly74_demo.model;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Passenger{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String documentNumber;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}