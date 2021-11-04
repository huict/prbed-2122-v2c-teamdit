package nl.hu.prbed.airline.fleet.application;

import nl.hu.prbed.airline.airline.application.exception.InvalidDTOException;
import nl.hu.prbed.airline.fleet.data.FleetRepository;
import nl.hu.prbed.airline.fleet.domain.Fleet;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneDTO;
import org.springframework.stereotype.Service;

@Service
public class FleetService {

    private final FleetRepository repository;

    public FleetService(FleetRepository repository){this.repository = repository;}

    public Fleet getFleet(){
        return repository.findAll().get(0);
    }

    public Plane addPlane(PlaneDTO dto){
        Fleet fleet = getFleet();
        if (dto.type == null){
            throw new InvalidDTOException("No type specified!");
        }
        Plane newPlane = new Plane(dto.type, dto.seatsEconomy, dto.seatsBusiness, dto.seatsFirstClass);
        fleet.addPlane(newPlane);
        repository.saveAndFlush(fleet);
        return newPlane;
    }

}
