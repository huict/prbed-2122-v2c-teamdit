package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.PlaneService;
import nl.hu.prbed.airline.airline.domain.Plane;
import nl.hu.prbed.airline.airline.presentation.dto.PlaneDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController(PlaneService planeService){
        this.planeService = planeService;
    }

    @GetMapping
    public List<Plane> getPlanes(){return planeService.getAllPlanes();}

    @GetMapping("/{id}")
    public Plane getPlaneByID(@PathVariable Long id) {
        return planeService.getPlaneById(id);
    }


    @PutMapping
    public Plane updatePlane(@RequestBody PlaneDTO dto){
        return planeService.updatePlane(dto);
    }

    @DeleteMapping
    public Boolean deletePlane(@PathVariable Long id){
        return planeService.deletePlane(id);
    }
}
