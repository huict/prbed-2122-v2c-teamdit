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

//    todo: login and logout here or in security????? @sam
    @PostMapping("/inloggen")
    public void login(){}


    @PostMapping("/uitloggen")
    public void logout(){}

}
