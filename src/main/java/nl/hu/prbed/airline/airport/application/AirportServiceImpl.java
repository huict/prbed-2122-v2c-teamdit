package nl.hu.prbed.airline.airport.application;

import nl.hu.prbed.airline.airport.application.exception.AirportAlreadyExistsException;
import nl.hu.prbed.airline.airport.application.exception.AirportInUseException;
import nl.hu.prbed.airline.airport.application.exception.AirportNotFoundException;
import nl.hu.prbed.airline.airport.application.exception.AirportCodeNotValidException;
import nl.hu.prbed.airline.airport.data.AirportRepository;
import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.airport.presentation.dto.AirportRequestDTO;
import nl.hu.prbed.airline.airport.presentation.dto.AirportResponseDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
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


    public Airport createAirport(AirportRequestDTO airportRequestDTO) {
        Airport airport = airportRequestDTO.toAirport();

        if (this.airportRepository.existsByCodeICAO(airport.getCodeICAO())) {
            throw new AirportAlreadyExistsException(airport.getCodeICAO());
        }

        if (airport.getCodeICAO().length() != 4) {
            throw new AirportCodeNotValidException(airport.getCodeICAO());
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

        try {
            this.airportRepository.deleteByCodeICAO(code);
        } catch (DataIntegrityViolationException e) {
            throw new AirportInUseException(code);
        }
    }

}
