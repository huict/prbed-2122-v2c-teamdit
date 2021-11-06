package nl.hu.prbed.airline.flightroute.presentation.dto;

import javax.validation.constraints.NotNull;

public class FlightrouteResponseDTO {
    @NotNull
    public Long id;
    @NotNull
    public String arrivalCode;
    @NotNull
    public String departureCode;
    @NotNull
    public int durationMinutes;
    @NotNull
    public double priceEconomy;
    @NotNull
    public double priceBusiness;
    @NotNull
    public double priceFirstClass;

}
