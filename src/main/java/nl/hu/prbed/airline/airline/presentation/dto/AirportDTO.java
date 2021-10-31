package nl.hu.prbed.airline.airline.presentation.dto;

import nl.hu.prbed.airline.airline.domain.Airport;

public class AirportDTO {
    public String code;
    public String name;
    public String city;
    public String country;
    public double longitude;
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
