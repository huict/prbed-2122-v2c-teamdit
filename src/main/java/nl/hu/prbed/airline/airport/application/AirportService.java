package nl.hu.prbed.airline.airport.application;

import nl.hu.prbed.airline.airport.application.exception.AirportAlreadyExistsException;
import nl.hu.prbed.airline.airport.application.exception.AirportNotFoundException;
import nl.hu.prbed.airline.airport.data.AirportRepository;
import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.airport.presentation.exception.AirportAlreadyExistsHTTPException;
import nl.hu.prbed.airline.airport.presentation.exception.AirportNotFoundHTTPException;
import nl.hu.prbed.airline.airport.presentation.dto.AirportRequestDTO;
import nl.hu.prbed.airline.airport.presentation.dto.AirportResponseDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport createAirport(AirportRequestDTO airportRequestDTO) {
        Airport airport = airportRequestDTO.toAirport();

        if (this.airportRepository.existsByCodeICAO(airport.getCodeICAO())) {
            throw new AirportAlreadyExistsException(airport.getCodeICAO());
        }

        this.airportRepository.save(airport);
        return airport;
    }

    public Airport updateAirport(AirportRequestDTO airportRequestDTO) {
        Airport updatedAirport = airportRequestDTO.toAirport();

        airportRepository.findByCodeICAO(updatedAirport.getCodeICAO())
                .orElseThrow(() -> new AirportNotFoundException(updatedAirport.getCodeICAO()));

        airportRepository.saveAndFlush(updatedAirport);
        return updatedAirport;
    }

    public void deleteAirport(String code) {
        this.airportRepository.findByCodeICAO(code)
            .orElseThrow(() -> new AirportNotFoundException(code));

        this.airportRepository.deleteByCodeICAO(code);
    }

    public List<AirportResponseDTO> getAllAirports() {
        List<Airport> airports = this.airportRepository.findAll();
        List<AirportResponseDTO> airportDTOS = new ArrayList<>();
        for (Airport airport : airports) {
            airportDTOS.add(new AirportResponseDTO(airport));
        }
        return airportDTOS;
    }

    public Airport findAirportByCodeICAO(String code) {
        return this.airportRepository.findByCodeICAO(code)
                .orElseThrow(() -> new AirportNotFoundException(code));
    }
}
