package nl.hu.prbed.vliegmaatschappij.presentation;

import nl.hu.prbed.vliegmaatschappij.application.AirlineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/airline")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

//    todo: login and logout here or in security????? @sam
    @PostMapping("/inloggen")
    public void login(){}


    @PostMapping("/uitloggen")
    public void logout(){}

}
