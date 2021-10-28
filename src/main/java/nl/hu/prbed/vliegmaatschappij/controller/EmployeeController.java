package nl.hu.prbed.vliegmaatschappij.controller;

import nl.hu.prbed.vliegmaatschappij.application.EmployeeService;
import nl.hu.prbed.vliegmaatschappij.domain.Employee;
import org.dom4j.io.ElementModifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//voor HATEOS zie link https://www.youtube.com/watch?v=KIFncw4RtEY&ab_channel=AlmightyJava

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService es;

    public EmployeeController(EmployeeService es) {
        this.es = es;
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

    //zoeken van luchthavens
    @GetMapping("/luchthaven/inzien")
    public void airportView() {
    }

    //toevoegen van luchthaven
    @PostMapping("/luchthaven/toevoegen")
    public void airportAdd() {
    }

    //aanpassen van luchthaven
    @PostMapping("/luchthaven/aanpassen")
    public void airportEdit() {

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
