package nl.hu.prbed.airline.plane.presentation.controller;

import nl.hu.prbed.airline.plane.application.PlaneService;
import nl.hu.prbed.airline.plane.application.exception.DuplicatePlaneException;
import nl.hu.prbed.airline.plane.application.exception.InvalidDTOException;
import nl.hu.prbed.airline.plane.application.exception.PlaneNotFoundException;
import nl.hu.prbed.airline.plane.application.exception.ReliantFlightsException;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneRequestDTO;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneResponseDTO;
import nl.hu.prbed.airline.plane.presentation.exception.DuplicatePlaneHTTPException;
import nl.hu.prbed.airline.plane.presentation.exception.InvalidDTOHTTPException;
import nl.hu.prbed.airline.plane.presentation.exception.PlaneNotFoundHTTPException;
import nl.hu.prbed.airline.plane.presentation.exception.ReliantFlightsHTTPException;
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
        try {
            return this.planeService.addPlane(planeRequestDTO);
        } catch (DuplicatePlaneException e){
            throw new DuplicatePlaneHTTPException(e.getMessage());
        } catch (InvalidDTOException e) {
            throw new InvalidDTOHTTPException("Invalid input");
        }
    }

    @GetMapping("/{id}")
    public PlaneResponseDTO getPlaneByID(@PathVariable Long id) {
        try {
            Plane plane = this.planeService.getPlaneById(id);
            return new PlaneResponseDTO(plane);
        }
        catch (PlaneNotFoundException e){
            throw new PlaneNotFoundHTTPException(id);
        }
    }

    @PutMapping
    public PlaneResponseDTO updatePlane(@RequestBody PlaneRequestDTO planeRequestDTO) {
        try {
            return this.planeService.updatePlane(planeRequestDTO);
        }
        catch (PlaneNotFoundException e){
            throw new PlaneNotFoundHTTPException(planeRequestDTO.id);
        }
    }

    @DeleteMapping("/{id}")
    public Boolean deletePlane(@PathVariable Long id) {
        try {
            return this.planeService.deletePlane(id);
        }
        catch (PlaneNotFoundException e){
            throw new PlaneNotFoundHTTPException(id);
        }
        catch (ReliantFlightsException e){
            throw new ReliantFlightsHTTPException("This plane still has reliant flights");
        }
    }
}
