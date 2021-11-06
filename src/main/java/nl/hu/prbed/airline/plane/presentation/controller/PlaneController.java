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

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping
    public List<PlaneResponseDTO> getPlanes() {
        return this.planeService.getAllPlanes();
    }

    @PostMapping
    public PlaneResponseDTO addPlane(@RequestBody PlaneRequestDTO planeRequestDTO) {
        return this.planeService.addPlane(planeRequestDTO);
    }

    @GetMapping("/{id}")
    public PlaneResponseDTO getPlaneByID(@PathVariable Long id) {
        Plane plane = this.planeService.getPlaneById(id);
        return new PlaneResponseDTO(plane);
    }

    @PutMapping
    public PlaneResponseDTO updatePlane(@RequestBody PlaneRequestDTO planeRequestDTO) {
        return this.planeService.updatePlane(planeRequestDTO);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePlane(@PathVariable Long id) {
        return this.planeService.deletePlane(id);
    }
}
