package nl.hu.prbed.vliegmaatschappij.airline.presentation.dto;

import nl.hu.prbed.vliegmaatschappij.airline.domain.Airport;

public class AirportDTO {
    public String code;
    public String name;
    public String city;
    public double longitude;
    public double latitude;

    public AirportDTO(){};

    public AirportDTO(Airport airport) {
        this.name = airport.getAirportName();
        this.city = airport.getCity();
        this.code = airport.getCode();
        this.longitude = airport.getLongitude();
        this.latitude = airport.getLatitude();
    }
}
