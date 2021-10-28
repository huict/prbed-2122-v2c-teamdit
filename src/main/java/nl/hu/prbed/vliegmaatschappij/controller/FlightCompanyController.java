package nl.hu.prbed.vliegmaatschappij.controller;

import nl.hu.prbed.vliegmaatschappij.application.FlightCompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/flightcompany")
public class FlightCompanyController {
    private final FlightCompanyService fcs;

    public FlightCompanyController(FlightCompanyService flightCompanyService) {
        this.fcs = flightCompanyService;
    }

//    ANON SECTION
    @PostMapping("/inloggen")
    public void login(){}

//    CUSTOMER SECTION
    @PostMapping("/customer/vlucht/zoek")
    public void flightsAvailableFind(){}

    @GetMapping("/customer/vlucht/inzien")
    public void flightsAvailableView(){}

    @PostMapping("/customer/vlucht/kies")
    public void flightsAvailablePick(){}

    @PostMapping("/customer/gegevens")
    public void customerDetailsFill(){}

    @PostMapping("/customer/bevestig")
    public void confirmBooking(){}

//    CUSTOMER + EMPLOYEE SECTION
    @PostMapping("/uitloggen")
    public void logout(){}

//    EMPLOYEE SECTION
    @GetMapping("/employee/vliegroute/inzien")
    public void flightrouteView(){}

    @PostMapping("/employee/vliegroute/toevoegen")
    public void flightrouteAdd(){}

    @PostMapping("/employee/vliegroute/aanpassen")
    public void flightrouteEdit(){}

    @GetMapping("/employee/luchthaven/inzien")
    public void airportView(){}

    @PostMapping("/employee/luchthaven/toevoegen")
    public void airportAdd(){}

    @PostMapping("/employee/luchthaven/aanpassen")
    public void airportEdit(){}

    @GetMapping("/employee/vliegtuig/inzien")
    public void planeView(){}

    @PostMapping("/employee/vliegtuig/toevoegen")
    public void planeAdd(){}

    @PostMapping("/employee/vliegtuig/aanpassen")
    public void planeEdit(){}

    @GetMapping("/employee/vlucht/inzien")
    public void flightView(){}

    @PostMapping("/employee/vlucht/toevoegen")
    public void flightAdd(){}

    @PostMapping("/employee/vlucht/aanpassen")
    public void flightEdit(){}

    @PostMapping("employee/vlucht/annuleren")
    public void flightCancel(){}

    @GetMapping("/employee/boeking/inzien")
    public void bookingView(){}

    @PostMapping("/employee/boeking/toevoegen")
    public void bookingAdd(){}

    @PostMapping("/employee/boeking/aanpassen")
    public void bookingEdit(){}

    @GetMapping("/employee/klant/inzien")
    public void customerView(){}

    @PostMapping("/employee/klant/toevoegen")
    public void customerAdd(){}

    @PostMapping("/employee/klant/aanpassen")
    public void customerEdit(){}

    @GetMapping("/employee/medewerker/inzien")
    public void employeeView(){}

    @PostMapping("/employee/medewerker/toevoegen")
    public void employeeAdd(){}

    @PostMapping("/employee/medewerker/aanpassen")
    public void employeeEdit(){}

    @DeleteMapping("employee/medewerker/verwijderen")
    public void employeeDelete(){}



//    private Service service
//
//    METHODS MAPPING
//    Use service
//    Do action with service method
//    Throw Exceptions domain entity
}
