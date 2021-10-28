package nl.hu.prbed.vliegmaatschappij.application;

import nl.hu.prbed.vliegmaatschappij.controller.DTO.AirportDTO;
import nl.hu.prbed.vliegmaatschappij.data.AirportRepository;
import nl.hu.prbed.vliegmaatschappij.domain.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final AirportRepository airportRepository;

    public EmployeeService(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    public void createAirport(AirportDTO airportDTO){
        Airport airport = new Airport(airportDTO.code, airportDTO.name, airportDTO.city, airportDTO.longitude, airportDTO.latitude);
        this.airportRepository.save(airport);
    }

    public void deleteAirport(AirportDTO airportDTO){
        Airport airport = findAirportbyCode(airportDTO.code);
        this.airportRepository.delete(airport);
    }

    public List<Airport> getAllAirports(){
        return this.airportRepository.findAll();
    }

    private Airport findAirportbyCode(String code){
        return  this.airportRepository.findByCode(code);
    }

}
