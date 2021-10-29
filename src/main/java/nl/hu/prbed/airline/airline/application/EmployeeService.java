package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.presentation.dto.AirportDTO;
import nl.hu.prbed.airline.airline.data.AirportRepository;
import nl.hu.prbed.airline.airline.domain.Airport;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final AirportRepository airportRepository;

    public EmployeeService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    // TODO: Custom exceptions
    public Airport createAirport(AirportDTO airportDTO) {
        try {
            assert !airportRepository.existsByCode(airportDTO.code);
        } catch (AssertionError e) {
            throw new RuntimeException("Airport already exists");
        }

        Airport airport = new Airport(airportDTO.code, airportDTO.name, airportDTO.city, airportDTO.country, airportDTO.longitude, airportDTO.latitude);
        this.airportRepository.save(airport);
        return airport;
    }

    // TODO: Maybe change exceptions
    public Airport updateAirport(AirportDTO airportDTO) {
        Airport airport = airportRepository.findByCode(airportDTO.code)
                .orElseThrow(() -> new UsernameNotFoundException(airportDTO.code));
        Airport updatedAirport = createAirport(airportDTO);
        airportRepository.saveAndFlush(updatedAirport);
        return updatedAirport;
    }

    public void deleteAirport(String code) {
        Airport airport = findAirportbyCode(code);
        airportRepository.delete(airport);
    }

    public List<Airport> getAllAirports() {
        return this.airportRepository.findAll();
    }

    //TODO: Maymbe change Exceptionsds
    //TODO: I think that we can change the request into a 404 error...
    public Airport findAirportbyCode(String code) {
        return this.airportRepository.findByCode(code)
                .orElseThrow(() -> new UsernameNotFoundException(code));
    }

}
