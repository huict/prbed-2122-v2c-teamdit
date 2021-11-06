package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.AirlineService;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/airline")
public class AirlineController {
    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping(path = "/plane")
    public List<PlaneResponseDTO> addPlane(@RequestParam("id") Long id){
        return airlineService.addPlane(id);
    }

}
