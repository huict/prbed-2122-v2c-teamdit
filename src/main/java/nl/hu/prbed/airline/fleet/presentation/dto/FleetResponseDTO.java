package nl.hu.prbed.airline.fleet.presentation.dto;

import nl.hu.prbed.airline.fleet.domain.Fleet;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class FleetResponseDTO {
    public long id;
    public List<PlaneResponseDTO> fleet = new ArrayList<>();

    public FleetResponseDTO(Fleet fleet) {
        this.id = fleet.getId();

        fleet.getPlanes().forEach(
                plane -> this.fleet.add(new PlaneResponseDTO(plane))
        );
    }
}
