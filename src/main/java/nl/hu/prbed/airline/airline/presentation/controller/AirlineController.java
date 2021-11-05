package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.AirlineService;
import nl.hu.prbed.airline.fleet.domain.Fleet;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/airline")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping(path = "/fleet")
    public Fleet addFleet(){
        return airlineService.addFleet();
    }

}
