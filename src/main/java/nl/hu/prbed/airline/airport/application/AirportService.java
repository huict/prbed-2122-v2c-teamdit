package nl.hu.prbed.airline.airport.application;

import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.airport.presentation.dto.AirportRequestDTO;
import nl.hu.prbed.airline.airport.presentation.dto.AirportResponseDTO;

import java.util.List;

public interface AirportService {
    List<AirportResponseDTO> getAllAirports();
    Airport findAirportByCodeICAO(String code);
    Airport createAirport(AirportRequestDTO airportRequestDTO);
    Airport updateAirport(AirportRequestDTO airportRequestDTO);
    void deleteAirport(String code);
}
