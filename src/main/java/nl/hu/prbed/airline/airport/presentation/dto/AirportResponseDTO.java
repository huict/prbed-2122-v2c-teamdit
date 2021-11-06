package nl.hu.prbed.airline.airport.presentation.dto;

import lombok.NoArgsConstructor;

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

}
