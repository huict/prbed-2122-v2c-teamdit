package nl.hu.prbed.airline.fleet.presentation.controller;

import nl.hu.prbed.airline.fleet.application.FleetService;
import nl.hu.prbed.airline.fleet.presentation.dto.FleetResponseDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fleet")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class FleetController {
    private final FleetService fleetService;

    public FleetController(FleetService fleetService) {
        this.fleetService = fleetService;
    }

    @GetMapping
    public FleetResponseDTO getFleet() {
        return this.fleetService.getFleet();
    }
}
