package nl.hu.prbed.vliegmaatschappij.controller;

import nl.hu.prbed.vliegmaatschappij.application.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService es;

    public EmployeeController(EmployeeService es) {
        this.es = es;
    }

    @GetMapping("/vliegroute/inzien")
    public void flightrouteView(){}

    @PostMapping("/vliegroute/toevoegen")
    public void flightrouteAdd(){}

    @PostMapping("/vliegroute/aanpassen")
    public void flightrouteEdit(){}

    @GetMapping("/luchthaven/inzien")
    public void airportView(){}

    @PostMapping("/luchthaven/toevoegen")
    public void airportAdd(){}

    @PostMapping("/luchthaven/aanpassen")
    public void airportEdit(){}

    @GetMapping("/vliegtuig/inzien")
    public void planeView(){}

    @PostMapping("/vliegtuig/toevoegen")
    public void planeAdd(){}

    @PostMapping("/vliegtuig/aanpassen")
    public void planeEdit(){}

    @GetMapping("/vlucht/inzien")
    public void flightView(){}

    @PostMapping("/vlucht/toevoegen")
    public void flightAdd(){}

    @PostMapping("/vlucht/aanpassen")
    public void flightEdit(){}

    @PostMapping("/vlucht/annuleren")
    public void flightCancel(){}

    @GetMapping("/boeking/inzien")
    public void bookingView(){}

    @PostMapping("/boeking/toevoegen")
    public void bookingAdd(){}

    @PostMapping("/boeking/aanpassen")
    public void bookingEdit(){}

    @GetMapping("/klant/inzien")
    public void customerView(){}

    @PostMapping("/klant/toevoegen")
    public void customerAdd(){}

    @PostMapping("/klant/aanpassen")
    public void customerEdit(){}

    @GetMapping("/medewerker/inzien")
    public void employeeView(){}

    @PostMapping("/medewerker/toevoegen")
    public void employeeAdd(){}

    @PostMapping("/medewerker/aanpassen")
    public void employeeEdit(){}

    @DeleteMapping("/medewerker/verwijderen")
    public void employeeDelete(){}
}
