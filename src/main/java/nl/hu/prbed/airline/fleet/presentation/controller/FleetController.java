package nl.hu.prbed.airline.fleet.presentation.controller;

import nl.hu.prbed.airline.fleet.application.FleetService;
import nl.hu.prbed.airline.fleet.domain.Fleet;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fleet")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class FleetController {

    private final FleetService fleetService;

    public FleetController(FleetService service){this.fleetService = service;}

    @PostMapping
    public Plane newPlane(@RequestBody PlaneDTO dto){
        return fleetService.addPlane(dto);
    }

    @GetMapping
    public Fleet getFleet(){
        return fleetService.getFleet();
    }


}
