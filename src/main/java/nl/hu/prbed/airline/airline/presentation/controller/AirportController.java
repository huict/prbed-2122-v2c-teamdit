package nl.hu.prbed.airline.airline.presentation.controller;

import nl.hu.prbed.airline.airline.application.AirportService;
import nl.hu.prbed.airline.airline.domain.Airport;
import nl.hu.prbed.airline.airline.presentation.dto.AirportDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/airport")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<AirportDTO> getAllAirports() {
        return this.airportService.getAllAirports();
    }

    @GetMapping("/{code}")
    public AirportDTO getAirportByCode(@PathVariable String code) {
        return new AirportDTO(this.airportService.findAirportByCode(code));
    }

    // Add airport
    @PostMapping
    public AirportDTO addAirport(@Validated @RequestBody AirportDTO airportDTO) {
        Airport airport = this.airportService.createAirport(airportDTO);
        return new AirportDTO(airport);
    }

    // Update airport
    @PutMapping
    public AirportDTO updateAirport(@Validated @RequestBody AirportDTO airportDTO) {
        Airport airport = this.airportService.updateAirport(airportDTO);
        return new AirportDTO(airport);
    }

    // Delete airport
    @DeleteMapping("/{code}")
    public void deleteAirport(@PathVariable String code) {
        this.airportService.deleteAirport(code);
    }
}
