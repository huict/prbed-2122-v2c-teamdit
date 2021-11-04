package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.NoAirlineExistsException;
import nl.hu.prbed.airline.airline.data.AirlineRepository;
import nl.hu.prbed.airline.airline.domain.Airline;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository){
        this.airlineRepository = airlineRepository;
    }

    public Airline getAirline(){
        try {
            return airlineRepository.findAll().get(0);
        }
        catch (IndexOutOfBoundsException e){
            throw new NoAirlineExistsException();
        }
    }
}
