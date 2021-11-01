package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.PlaneService;
import nl.hu.prbed.airline.airline.domain.Airport;
import nl.hu.prbed.airline.airline.domain.Plane;
import nl.hu.prbed.airline.airline.presentation.dto.PlaneDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plane")
public class PlaneController {

    private final PlaneService service;
    public PlaneController(PlaneService service){this.service = service;}

    @GetMapping
    public List<Plane> getPlanes(){return service.getAllPlanes();}

    // Get airport by code
    @GetMapping("/{id}")
    public Plane getPlaneByID(@PathVariable Long id) {
        return service.getPlane(id);
    }

    @PostMapping
    public Plane newPlane(PlaneDTO dto){
        return service.addPlane(dto);
    }

    @PutMapping
    public Plane updatePlane(PlaneDTO dto){
        return service.updatePlane(dto);
    }

}