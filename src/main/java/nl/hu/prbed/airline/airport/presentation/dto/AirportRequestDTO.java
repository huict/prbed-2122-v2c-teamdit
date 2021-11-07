package nl.hu.prbed.airline.airport.presentation.dto;

import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.airport.domain.Airport;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class AirportRequestDTO {
    @NotNull
    public String codeICAO;
    @NotNull
    public String name;
    @NotNull
    public String city;
    @NotNull
    public String country;
    @NotNull
    public double longitude;
    @NotNull
    public double latitude;

    public Airport toAirport() {
        return new Airport(codeICAO,
                name,
                city,
                country,
                longitude,
                latitude);
    }
}
