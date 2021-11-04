package nl.hu.prbed.airline.fleet.presentation.controller;

import nl.hu.prbed.airline.fleet.application.FleetService;
import nl.hu.prbed.airline.fleet.domain.Fleet;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneDTO;
import org.springframework.web.bind.annotation.*;

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
