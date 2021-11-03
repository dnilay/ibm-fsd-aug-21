package com.example.demo.model;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

@Entity
@Data
@Table(name="flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String flightNumber;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	private Date dateOfDeparture;
	private Time estimatedDepartureTime;



}
