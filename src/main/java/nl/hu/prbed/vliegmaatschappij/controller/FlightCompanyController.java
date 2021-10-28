package nl.hu.prbed.vliegmaatschappij.controller;

import nl.hu.prbed.vliegmaatschappij.application.FlightCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "flightcompany")
public class FlightCompanyController {

    private final FlightCompanyService fcs;

    public FlightCompanyController(FlightCompanyController flightCompanyController){
        this.fcs = 
    }


//    private Service service
//
//    METHODS MAPPING
//    Use service
//    Do action with service method
//    Throw Exceptions domain entity
}
