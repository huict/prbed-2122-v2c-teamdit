package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.data.AirportRepository;
import nl.hu.prbed.airline.airline.domain.Airport;
import nl.hu.prbed.airline.airline.application.exception.AirportAlreadyExistsException;
import nl.hu.prbed.airline.airline.application.exception.AirportNotFoundException;
import nl.hu.prbed.airline.airline.domain.FlightRoute;
import nl.hu.prbed.airline.airline.presentation.dto.AirportDTO;
import nl.hu.prbed.airline.airline.presentation.dto.FlightRouteDTO;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
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

    public Airport createAirport(AirportDTO airportDTO) {
        Airport airport = airportDTO.toAirport();

        if (this.airportRepository.existsByCode(airport.getCode())) {
            throw new AirportAlreadyExistsException(airport.getCode());
        }

        this.airportRepository.save(airport);
        return airport;
    }

    public Airport updateAirport(AirportDTO airportDTO) {
        Airport updatedAirport = airportDTO.toAirport();

        airportRepository.findByCode(updatedAirport.getCode())
                .orElseThrow(() -> new AirportNotFoundException(updatedAirport.getCode()));

        airportRepository.saveAndFlush(updatedAirport);
        return updatedAirport;
    }

    public void deleteAirport(String code) {
        this.airportRepository.findByCode(code)
            .orElseThrow(() -> new AirportNotFoundException(code));

        this.airportRepository.deleteByCode(code);
    }

    public List<AirportDTO> getAllAirports() {
        List<Airport> airports = this.airportRepository.findAll();
        List<AirportDTO> airportDTOS = new ArrayList<>();
        for (Airport airport : airports) {
            airportDTOS.add(new AirportDTO(airport));
        }
        return airportDTOS;
    }

    public Airport findAirportByCode(String code) {
        return this.airportRepository.findByCode(code)
                .orElseThrow(() -> new AirportNotFoundException(code));
    }
}
