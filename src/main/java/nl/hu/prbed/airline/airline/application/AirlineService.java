package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.MoreThanOneFleetException;
import nl.hu.prbed.airline.airline.application.exception.NoAirlineExistsException;
import nl.hu.prbed.airline.airline.data.AirlineRepository;
import nl.hu.prbed.airline.airline.domain.Airline;
import nl.hu.prbed.airline.fleet.data.FleetRepository;
import nl.hu.prbed.airline.fleet.domain.Fleet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;
    private final FleetRepository fleetRepository;

    public AirlineService(AirlineRepository airlineRepository, FleetRepository fleetRepository){
        this.airlineRepository = airlineRepository;
        this.fleetRepository = fleetRepository;
    }

    public Airline getAirline(){
        try {
            return airlineRepository.findAll().get(0);
        }
        catch (IndexOutOfBoundsException e){
            throw new NoAirlineExistsException();
        }
    }

    public Fleet addFleet(){
        if(fleetRepository.findAll().isEmpty()) {
            Fleet newFleet = new Fleet(new ArrayList<>());
            fleetRepository.save(newFleet);
            return newFleet;
        }
        throw new MoreThanOneFleetException("There is already a fleet defined!");
    }

}
