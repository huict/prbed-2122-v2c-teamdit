package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.PlaneService;
import nl.hu.prbed.airline.airline.domain.Plane;
import nl.hu.prbed.airline.airline.presentation.dto.PlaneDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaneController {

    private final PlaneService service;

    public PlaneController(PlaneService service){
        this.service = service;
    }

    @GetMapping
    public List<Plane> getPlanes(){return service.getAllPlanes();}

    @GetMapping("/{id}")
    public Plane getPlaneByID(@PathVariable Long id) {
        return service.getPlane(id);
    }


    @PutMapping
    public Plane updatePlane(@RequestBody PlaneDTO dto){
        return service.updatePlane(dto);
    }

    @DeleteMapping
    public Boolean deletePlane(@RequestBody PlaneDTO dto){
        return service.deletePlane(dto);
    }
}
