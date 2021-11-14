package nl.hu.prbed.airline.plane.presentation.controller;

import nl.hu.prbed.airline.plane.application.PlaneService;
import nl.hu.prbed.airline.plane.application.PlaneServiceImpl;
import nl.hu.prbed.airline.plane.application.exception.InvalidDTOException;
import nl.hu.prbed.airline.plane.application.exception.PlaneNotFoundException;
import nl.hu.prbed.airline.plane.application.exception.PlaneInUseException;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneRequestDTO;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneResponseDTO;
import nl.hu.prbed.airline.plane.presentation.exception.InvalidDTOHTTPException;
import nl.hu.prbed.airline.plane.presentation.exception.PlaneInUseHTTPException;
import nl.hu.prbed.airline.plane.presentation.exception.PlaneNotFoundHTTPException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plane")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class PlaneController {
    private final PlaneService planeService;

    public PlaneController(PlaneServiceImpl planeService) {
        this.planeService = planeService;
    }

    @GetMapping
    public List<PlaneResponseDTO> getPlanes() {
        return this.planeService.getAllPlanes();
    }

    @PostMapping
    public PlaneResponseDTO addPlane(@RequestBody PlaneRequestDTO planeRequestDTO) {
        try {
            return this.planeService.addPlane(planeRequestDTO);
        } catch (InvalidDTOException e) {
            throw new InvalidDTOHTTPException("Invalid input");
        }
    }

    @GetMapping("/{id}")
    public PlaneResponseDTO getPlaneByID(@PathVariable Long id) {
        try {
            Plane plane = this.planeService.getPlaneById(id);
            return new PlaneResponseDTO(plane);
        } catch (PlaneNotFoundException e) {
            throw new PlaneNotFoundHTTPException(id);
        }
    }

    @PutMapping
    public PlaneResponseDTO updatePlane(@RequestBody PlaneRequestDTO planeRequestDTO) {
        try {
            return this.planeService.updatePlane(planeRequestDTO);
        } catch (PlaneNotFoundException e) {
            throw new PlaneNotFoundHTTPException(planeRequestDTO.id);
        }
    }

    @DeleteMapping("/{id}")
    public Boolean deletePlane(@PathVariable Long id) {
        try {
            return this.planeService.deletePlane(id);
        } catch (PlaneNotFoundException e) {
            throw new PlaneNotFoundHTTPException(id);
        } catch (DataIntegrityViolationException e) {
            throw new PlaneInUseHTTPException("Plane is still in use");
        }
    }
}
