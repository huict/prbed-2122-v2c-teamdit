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

//    //zoeken van vliegroute
//    @GetMapping("/vliegroute")
//    public void flightrouteView() {
//    }
//
//
//    //vliegroute toevoegen
//    @PostMapping("/vliegroute")
//    public void flightrouteAdd() {
//    }
//
//    //vliegroute aanpassen
//    @PostMapping("/vliegroute")
//    public void flightrouteEdit() {
//
//    }

    //toevoegen van luchthaven
    @GetMapping("/luchthaven")
    public List<Airport> airportView() {
        try {
            return this.employeeService.getAllAirports();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, exception.getMessage());
        }
    }

    //zoeken van luchthavens
    @GetMapping("/luchthaven/{code}")
    public Airport airportView(@PathVariable String code) {
        try {
            return this.employeeService.findAirportbyCode(code);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, exception.getMessage());
        }
    }

    //toevoegen van luchthaven
    @PostMapping("/luchthaven/")
    public AirportDTO airportAdd(Authentication authentication, @Validated @RequestBody AirportDTO airportDTO) {
            UserProfile profile = (UserProfile) authentication.getPrincipal();
            Airport airport = this.employeeService.createAirport(airportDTO);
            return new AirportDTO(airport);
    }

    //updaten airport
    @PutMapping("/luchthaven")
    public void airportUpdate(@Validated @RequestBody AirportDTO airportDTO) {
        this.employeeService.updateAirport(airportDTO);
    }

    //verwijderen van luchthaven
    @DeleteMapping("/luchthaven/{code}")
    public void airportDelete(@PathVariable String code) {
        employeeService.deleteAirport(code);
    }

//    //zoeken van vliegtuig op basis van id
//    @GetMapping("/vliegtuig")
//    public void planeView() {
//    }
//
//    //toevoegen van vliegtuig
//    @PostMapping("/vliegtuig")
//    public void planeAdd() {
//    }
//
//    //aanpassen van vliegtuig op basis van id
//    @PostMapping("/vliegtuig/aanpassen")
//    public void planeEdit() {
//    }
//
//    //zoeken van alle vluchten
//    @GetMapping("/vlucht")
//    public void flightView() {
//    }
//
//    //toevoegen van vlucht
//    @PostMapping("/vlucht")
//    public void flightAdd() {
//    }
//
//    //aanpassen van vlucht op basis van id/naam
//    @PostMapping("/vlucht")
//    public void flightEdit() {
//    }
//
//    //annuleren van vlucht op basis van id
//    @PostMapping("/vlucht")
//    public void flightCancel() {
//    }
//
//    //zoeken van boekingen
//    @GetMapping("/boeking")
//    public void bookingView() {
//    }
//
//    //toevoegen van boeking
//    @PostMapping("/boeking")
//    public void bookingAdd() {
//    }
//
//    //aanpassen van boeking op basis van id
//    @PutMapping("/boeking")
//    public void bookingEdit() {
//    }
//
//    //zoeken van alle klanten
//    @GetMapping("/klant")
//    public void customerView() {
//    }
//
//    //toevoegen van klant
//    @PostMapping("/klant")
//    public void customerAdd() {
//    }
//
//    //aanpassen van klant op basis van id
//    @PutMapping("/klant")
//    public void customerEdit() {
//    }
//
//    //zoeken van medewerkers
//    @GetMapping("/medewerker")
//    public void employeeView() {
//    }
//
//    //toevoegen van medewerker
//    @PostMapping("/medewerker")
//    public void employeeAdd() {
//    }
//
//    //aanpassen van medewerker
//    @PutMapping("/medewerker")
//    public void employeeEdit() {
//    }
//
//    //verwijderen van medewerker
//    @DeleteMapping("/medewerker")
//    public void employeeDelete() {
//    }
}
