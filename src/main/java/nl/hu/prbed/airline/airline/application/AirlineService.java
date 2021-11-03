package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.NoAirlineExistsException;
import nl.hu.prbed.airline.airline.data.AirlineRepository;
import nl.hu.prbed.airline.airline.domain.Airline;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private final AirlineRepository repository;

    public AirlineService(AirlineRepository repository){
        this.repository = repository;
    }

    public Airline getAirline(){
        try {
            return repository.findAll().get(0);
        }
        catch (IndexOutOfBoundsException e){
            throw new NoAirlineExistsException();
        }
    }
}
