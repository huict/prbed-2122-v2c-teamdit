package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.EmployeeService;
import nl.hu.prbed.airline.airline.presentation.dto.AirportDTO;
import nl.hu.prbed.airline.airline.domain.Airport;
import org.springframework.http.HttpStatus;
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

    // Ophalen van alle luchthavens
    @GetMapping("/airport")
    public List<Airport> airportView() {
        try {
            return this.employeeService.getAllAirports();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, exception.getMessage());
        }
    }

    // Zoeken van luchthaven op code
    @GetMapping("/airport/{code}")
    public Airport airportView(@PathVariable String code) {
        return this.employeeService.findAirportbyCode(code);
    }

    // Toevoegen van luchthaven
    @PostMapping("/airport")
    public AirportDTO airportAdd(@Validated @RequestBody AirportDTO airportDTO) {
        Airport airport = this.employeeService.createAirport(airportDTO);
        return new AirportDTO(airport);
    }

    // Updaten airport
    @PutMapping("/airport")
    public AirportDTO airportUpdate(@Validated @RequestBody AirportDTO airportDTO) {
        Airport airport = this.employeeService.updateAirport(airportDTO);
        return new AirportDTO(airport);
    }

    // Delete airport
    @DeleteMapping("/airport/{code}")
    public void airportDelete(@PathVariable String code) {
        this.employeeService.deleteAirport(code);
    }
}
