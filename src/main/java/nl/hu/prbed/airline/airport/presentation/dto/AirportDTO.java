package nl.hu.prbed.airline.airport.presentation.dto;

import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.airport.domain.Airport;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class AirportDTO {
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

    public AirportDTO(Airport airport) {
        this.codeICAO = airport.getCodeICAO();
        this.name = airport.getAirportName();
        this.city = airport.getCity();
        this.country = airport.getCountry();
        this.longitude = airport.getLongitude();
        this.latitude = airport.getLatitude();
    }

    public Airport toAirport() {
        return new Airport(codeICAO,
                name,
                city,
                country,
                longitude,
                latitude);
    }
}
