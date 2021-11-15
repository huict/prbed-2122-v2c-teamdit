package nl.hu.prbed.airline.airport.presentation.controller;

import nl.hu.prbed.airline.airport.application.AirportService;
import nl.hu.prbed.airline.airport.application.AirportServiceImpl;
import nl.hu.prbed.airline.airport.application.exception.AirportAlreadyExistsException;
import nl.hu.prbed.airline.airport.application.exception.AirportNotFoundException;
import nl.hu.prbed.airline.airport.application.exception.AirportCodeNotValidException;
import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.airport.presentation.dto.AirportRequestDTO;
import nl.hu.prbed.airline.airport.presentation.dto.AirportResponseDTO;
import nl.hu.prbed.airline.airport.presentation.exception.AirportAlreadyExistsHTTPException;
import nl.hu.prbed.airline.airport.presentation.exception.AirportCodeNotValidHTTPException;
import nl.hu.prbed.airline.airport.presentation.exception.AirportInUseHTTPException;
import nl.hu.prbed.airline.airport.presentation.exception.AirportNotFoundHTTPException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/airport")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportServiceImpl airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<AirportResponseDTO> getAllAirports() {
        return this.airportService.getAllAirports();
    }

    @GetMapping("/{code}")
    public AirportResponseDTO getAirportByCodeICAO(@PathVariable String code) {
        try {
            return new AirportResponseDTO(this.airportService.findAirportByCodeICAO(code));
        } catch (AirportNotFoundException e) {
            throw new AirportNotFoundHTTPException(code);
        }
    }

    // Add airport
    @PostMapping
    public AirportResponseDTO addAirport(@Validated @RequestBody AirportRequestDTO airportRequestDTO) {
        try {
            Airport airport = this.airportService.createAirport(airportRequestDTO);
            return new AirportResponseDTO(airport);
        } catch (AirportAlreadyExistsException e) {
            throw new AirportAlreadyExistsHTTPException(airportRequestDTO.codeICAO);
        } catch (AirportCodeNotValidException e) {
            throw new AirportCodeNotValidHTTPException(airportRequestDTO.codeICAO);
        }
    }

    // Update airport
    @PutMapping
    public AirportResponseDTO updateAirport(@Validated @RequestBody AirportRequestDTO airportRequestDTO) {
        try {
            Airport airport = this.airportService.updateAirport(airportRequestDTO);
            return new AirportResponseDTO(airport);
        } catch (AirportNotFoundException e) {
            throw new AirportNotFoundHTTPException(airportRequestDTO.codeICAO);
        }
    }

    // Delete airport
    @DeleteMapping("/{code}")
    public void deleteAirport(@PathVariable String code) {
        try {
            this.airportService.deleteAirport(code);
        } catch (AirportNotFoundException e) {
            throw new AirportNotFoundHTTPException(code);
        }   catch (DataIntegrityViolationException e) {
            throw new AirportInUseHTTPException(code);
        }

    }
}
