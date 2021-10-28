package nl.hu.prbed.vliegmaatschappij.controller;

import nl.hu.prbed.vliegmaatschappij.application.EmployeeService;
import nl.hu.prbed.vliegmaatschappij.controller.DTO.AirportDTO;
import nl.hu.prbed.vliegmaatschappij.domain.Airport;
import nl.hu.prbed.vliegmaatschappij.domain.Employee;
import org.apache.el.parser.AstOr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//voor HATEOS zie link https://www.youtube.com/watch?v=KIFncw4RtEY&ab_channel=AlmightyJava

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //zoeken van vliegroute
    @GetMapping("/vliegroute")
    public void flightrouteView() {
    }

    private ResponseEntity<Collection<Employee>> getCollectionResponseEntity() {
        Collection<Employee> employees = new ArrayList<>();
        List<Employee> response = new ArrayList<>();

        employees.forEach(employee -> {
            if (employees.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
//            employee.add(linkTo(methodOn(EmployeeController.class).findByid(employee.getId())).withSelfRel());
            response.add(employee);
        });

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //vliegroute toevoegen
    @PostMapping("/vliegroute")
    public void flightrouteAdd() {
    }

    //vliegroute aanpassen
    @PostMapping("/vliegroute")
    public void flightrouteEdit() {

    }

    //toevoegen van luchthaven
    @GetMapping("/luchthaven/")
    public List<Airport> airportView() {
        try {
            List<Airport> airports = this.service.getAllAirports();
            return airports;
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, exception.getMessage());
        }
    }

    //zoeken van luchthavens
    @GetMapping("/luchthaven/{code}")
    public Airport airportView(@PathVariable String code) {
        try {
            Airport airport= this.service.findAirportbyCode(code);
            return airport;
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, exception.getMessage());
        }
    }

    //toevoegen van luchthaven
    @PostMapping("/luchthaven/")
    public AirportDTO airportAdd(@Validated @RequestBody AirportDTO airportDTO) {
            Airport airport = this.service.createAirport(airportDTO);
            return new AirportDTO(airport);
    }

    //updaten airport
    @PutMapping("/luchthaven")
    public void airportUpdate(@Validated @RequestBody AirportDTO airportDTO) {
        this.service.updateAirport(airportDTO);
    }

    //verwijderen van luchthaven
    @DeleteMapping("/luchthaven/{code}")
    public void airportDelete(@PathVariable String code) {
        service.deleteAirport(code);
    }

    //zoeken van vliegtuig op basis van id
    @GetMapping("/vliegtuig")
    public void planeView() {
    }

    //toevoegen van vliegtuig
    @PostMapping("/vliegtuig")
    public void planeAdd() {
    }

    //aanpassen van vliegtuig op basis van id
    @PostMapping("/vliegtuig/aanpassen")
    public void planeEdit() {
    }

    //zoeken van alle vluchten
    @GetMapping("/vlucht")
    public void flightView() {
    }

    //toevoegen van vlucht
    @PostMapping("/vlucht")
    public void flightAdd() {
    }

    //aanpassen van vlucht op basis van id/naam
    @PostMapping("/vlucht")
    public void flightEdit() {
    }

    //annuleren van vlucht op basis van id
    @PostMapping("/vlucht")
    public void flightCancel() {
    }

    //zoeken van boekingen
    @GetMapping("/boeking")
    public void bookingView() {
    }

    //toevoegen van boeking
    @PostMapping("/boeking")
    public void bookingAdd() {
    }

    //aanpassen van boeking op basis van id
    @PutMapping("/boeking")
    public void bookingEdit() {
    }

    //zoeken van alle klanten
    @GetMapping("/klant")
    public void customerView() {
    }

    //toevoegen van klant
    @PostMapping("/klant")
    public void customerAdd() {
    }

    //aanpassen van klant op basis van id
    @PutMapping("/klant")
    public void customerEdit() {
    }

    //zoeken van medewerkers
    @GetMapping("/medewerker")
    public void employeeView() {
    }

    //toevoegen van medewerker
    @PostMapping("/medewerker")
    public void employeeAdd() {
    }

    //aanpassen van medewerker
    @PostMapping("/medewerker")
    public void employeeEdit() {
    }

    //verwijderen van medewerker
    @DeleteMapping("/medewerker")
    public void employeeDelete() {
    }
}
