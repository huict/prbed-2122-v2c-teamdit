package nl.hu.prbed.airline.airport.presentation.dto;

import nl.hu.prbed.airline.airport.domain.Airport;

import javax.validation.constraints.NotNull;

public class AirportDTO {

    @NotNull
    public String code;
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

    public AirportDTO() {

    }

    public AirportDTO(Airport airport) {
        this.code = airport.getCode();
        this.name = airport.getAirportName();
        this.city = airport.getCity();
        this.country = airport.getCountry();
        this.longitude = airport.getLongitude();
        this.latitude = airport.getLatitude();
    }

    public Airport toAirport() {
        return new Airport(code,
                name,
                city,
                country,
                longitude,
                latitude);
    }
}
