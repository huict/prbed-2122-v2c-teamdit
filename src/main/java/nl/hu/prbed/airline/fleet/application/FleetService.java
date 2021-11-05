package nl.hu.prbed.airline.fleet.application;

import nl.hu.prbed.airline.airline.application.exception.InvalidDTOException;
import nl.hu.prbed.airline.fleet.data.FleetRepository;
import nl.hu.prbed.airline.fleet.domain.Fleet;
import nl.hu.prbed.airline.fleet.exception.FleetDoesntExistException;
import nl.hu.prbed.airline.fleet.presentation.controller.dto.FleetDTO;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneDTO;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.FlowEntryToken;

import java.util.ArrayList;

@Service
public class FleetService {

    private final FleetRepository repository;

    public FleetService(FleetRepository repository) {
        this.repository = repository;
    }

    public Fleet createFleet(FleetDTO fleetDTO) {
        Fleet fleet = new Fleet(fleetDTO.planes = new ArrayList<>());
        repository.save(fleet);
        return fleet;
    }

    public Fleet getFleet() {
        try {
            return repository.findAll().get(0);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new FleetDoesntExistException();
        }
    }

    public Plane addPlane(PlaneDTO dto) {
        Fleet fleet = getFleet();
        if (dto.type == null) {
            throw new InvalidDTOException("No type specified!");
        }
        Plane newPlane = new Plane(dto.type, dto.seatsEconomy, dto.seatsBusiness, dto.seatsFirstClass);
        fleet.addPlane(newPlane);
        repository.saveAndFlush(fleet);
        return newPlane;
    }

}
