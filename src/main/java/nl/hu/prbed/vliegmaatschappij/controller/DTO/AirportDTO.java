package nl.hu.prbed.vliegmaatschappij.controller.DTO;

import nl.hu.prbed.vliegmaatschappij.domain.Airport;

public class AirportDTO {
    public String name;
    public String city;
    public String code;
    public double longitude;
    public double latitude;

    public AirportDTO(Airport airport) {
        this.name = airport.getAirportName();
        this.city = airport.getCity();
        this.code = airport.getCode();
        this.longitude = airport.getLongitude();
        this.latitude = airport.getLatitude();
    }
}
