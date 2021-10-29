package nl.hu.prbed.vliegmaatschappij.airline.presentation.controller;

import nl.hu.prbed.vliegmaatschappij.airline.application.EmployeeService;
import nl.hu.prbed.vliegmaatschappij.airline.presentation.dto.AirportDTO;
import nl.hu.prbed.vliegmaatschappij.airline.domain.Airport;
import nl.hu.prbed.vliegmaatschappij.security.domain.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //ophalen van alle luchthavens
    @GetMapping("/airport")
    public List<Airport> airportView() {
        try {
            return this.employeeService.getAllAirports();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, exception.getMessage());
        }
    }

    //zoeken van luchthaven op code
    @GetMapping("/airport/{code}")
    public Airport airportView(@PathVariable String code) {
        try {
            return this.employeeService.findAirportbyCode(code);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, exception.getMessage());
        }
    }

    //toevoegen van luchthaven
    @PostMapping("/airport")
    public AirportDTO airportAdd(@Validated @RequestBody AirportDTO airportDTO) {
            Airport airport = this.employeeService.createAirport(airportDTO);
            return new AirportDTO(airport);
    }

    //updaten airport
    @PutMapping("/airport")
    public void airportUpdate(@Validated @RequestBody AirportDTO airportDTO) {
        this.employeeService.updateAirport(airportDTO);
    }

    //verwijderen van luchthaven
    @DeleteMapping("/airport/{code}")
    public void airportDelete(@PathVariable String code) {
        employeeService.deleteAirport(code);
    }
}
