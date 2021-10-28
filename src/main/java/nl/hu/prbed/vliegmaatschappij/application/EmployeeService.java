package nl.hu.prbed.vliegmaatschappij.application;

import nl.hu.prbed.vliegmaatschappij.controller.DTO.AirportDTO;
import nl.hu.prbed.vliegmaatschappij.data.AirportRepository;
import nl.hu.prbed.vliegmaatschappij.domain.Airport;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final AirportRepository airportRepository;

    public EmployeeService(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    public Airport createAirport(AirportDTO airportDTO){
        Airport airport = new Airport(airportDTO.code, airportDTO.name, airportDTO.city, airportDTO.longitude, airportDTO.latitude);
        this.airportRepository.save(airport);
        return airport;
    }

    public void updateAirport(AirportDTO airportDTO){
        Optional<Airport> airport = airportRepository.findByCode(airportDTO.code);
        if (airport != null){
           Airport updatedAirport = createAirport(airportDTO);
           airportRepository.saveAndFlush(updatedAirport);
        }
    }

    public void deleteAirport(AirportDTO airportDTO){
        Airport airport = findAirportbyCode(airportDTO.code);
        this.airportRepository.delete(airport);
    }

    public List<Airport> getAllAirports(){
        return this.airportRepository.findAll();
    }

    public Airport findAirportbyCode(String code){
        return  this.airportRepository.findByCode(code)
                .orElseThrow(() -> new UsernameNotFoundException(code));
    }

}
