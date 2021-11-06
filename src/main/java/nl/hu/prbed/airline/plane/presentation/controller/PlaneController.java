package nl.hu.prbed.airline.plane.presentation.controller;

import nl.hu.prbed.airline.plane.application.PlaneService;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneDTO;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneRequestDTO;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneResponseDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plane")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController(PlaneService planeService){
        this.planeService = planeService;
    }

    @GetMapping
    public List<Plane> getPlanes(){return planeService.getAllPlanes();}

    @GetMapping("/{id}")
    public PlaneResponseDTO getPlaneByID(@PathVariable Long id) {
        Plane plane = planeService.getPlaneById(id);
        return new PlaneResponseDTO(plane);
    }


    @PutMapping
    public PlaneResponseDTO updatePlane(@RequestBody PlaneRequestDTO planeRequestDTO){
        Plane plane =  planeService.updatePlane(planeRequestDTO);
        return new PlaneResponseDTO(plane);
    }

    @DeleteMapping
    public Boolean deletePlane(@PathVariable Long id){
        return planeService.deletePlane(id);
    }
}
