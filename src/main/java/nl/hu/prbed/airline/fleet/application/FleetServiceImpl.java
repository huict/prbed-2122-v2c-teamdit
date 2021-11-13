package nl.hu.prbed.airline.fleet.application;

import nl.hu.prbed.airline.airline.application.AirlineServiceImpl;
import nl.hu.prbed.airline.airline.domain.Airline;
import nl.hu.prbed.airline.fleet.data.FleetRepository;
import nl.hu.prbed.airline.fleet.domain.Fleet;
import nl.hu.prbed.airline.fleet.presentation.dto.FleetResponseDTO;
import nl.hu.prbed.airline.plane.domain.Plane;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FleetServiceImpl implements FleetService {
    private final FleetRepository fleetRepository;
    private final AirlineServiceImpl airlineService;

    public FleetServiceImpl(FleetRepository fleetRepository, AirlineServiceImpl airlineService) {
        this.fleetRepository = fleetRepository;
        this.airlineService = airlineService;
    }

    public void addPlane(Plane plane) {
        Fleet fleet = getFleetForAirline();
        fleet.addPlane(plane);
        fleetRepository.saveAndFlush(fleet);
    }

    public FleetResponseDTO getFleet() {
        return new FleetResponseDTO(this.getFleetForAirline());
    }

    public Fleet getFleetForAirline() {
        Airline airline = airlineService.getAirline();
        return airline.getFleet();
    }
}
