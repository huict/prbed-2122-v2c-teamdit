package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.FleetService;
import nl.hu.prbed.airline.airline.domain.Fleet;
import nl.hu.prbed.airline.airline.domain.Plane;
import nl.hu.prbed.airline.airline.presentation.dto.PlaneDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fleet")
public class FleetController {

    private final FleetService service;

    public FleetController(FleetService service){this.service = service;}

    @PostMapping
    public Plane newPlane(@RequestBody PlaneDTO dto){
        return service.addPlane(dto);
    }

    @GetMapping
    public Fleet getFleet(){
        return service.getFleet();
    }


}
