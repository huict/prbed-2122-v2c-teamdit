package nl.hu.prbed.airline.plane.application;

import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneRequestDTO;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneResponseDTO;

import java.util.List;

public interface PlaneService {
    PlaneResponseDTO addPlane(PlaneRequestDTO pro);
    PlaneResponseDTO updatePlane(PlaneRequestDTO planeRequestDTO);
    Plane getPlaneById(Long id);
    List<PlaneResponseDTO> getAllPlanes();
    Boolean deletePlane(Long id);
}
