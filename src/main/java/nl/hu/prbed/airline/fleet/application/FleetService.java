package nl.hu.prbed.airline.fleet.application;

import nl.hu.prbed.airline.fleet.domain.Fleet;
import nl.hu.prbed.airline.fleet.presentation.dto.FleetResponseDTO;
import nl.hu.prbed.airline.plane.domain.Plane;

public interface FleetService {
    void addPlane(Plane plane);
    FleetResponseDTO getFleet();
    Fleet getFleetForAirline();
}
