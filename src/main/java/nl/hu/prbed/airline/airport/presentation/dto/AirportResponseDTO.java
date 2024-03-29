package nl.hu.prbed.airline.airport.presentation.dto;

import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.airport.domain.Airport;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class AirportResponseDTO {
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

    public AirportResponseDTO(Airport airport) {
        this.codeICAO = airport.getCodeICAO();
        this.name = airport.getAirportName();
        this.city = airport.getCity();
        this.country = airport.getCountry();
        this.longitude = airport.getLongitude();
        this.latitude = airport.getLatitude();
    }

}
