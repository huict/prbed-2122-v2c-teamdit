package nl.hu.prbed.vliegmaatschappij.airline.application;

import nl.hu.prbed.vliegmaatschappij.airline.presentation.dto.AirportDTO;
import nl.hu.prbed.vliegmaatschappij.airline.data.AirportRepository;
import nl.hu.prbed.vliegmaatschappij.airline.domain.Airport;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final AirportRepository airportRepository;

    public EmployeeService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport createAirport(AirportDTO airportDTO) {
        Airport airport = new Airport(airportDTO.code, airportDTO.name, airportDTO.city, airportDTO.longitude, airportDTO.latitude);
        this.airportRepository.save(airport);
        return airport;
    }

    //TODO: Maymbe change Exceptionsds
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
    public Airport findAirportbyCode(String code) {
        return this.airportRepository.findByCode(code)
                .orElseThrow(() -> new UsernameNotFoundException(code));
    }

}
