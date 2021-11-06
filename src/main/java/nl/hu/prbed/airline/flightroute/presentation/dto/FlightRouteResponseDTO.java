package nl.hu.prbed.airline.flightroute.presentation.dto;

import javax.validation.constraints.NotNull;

public class FlightRouteResponseDTO {
    @NotNull
    public Long id;
    @NotNull
    public String arrivalCodeICAO;
    @NotNull
    public String departureCodeICAO;
    @NotNull
    public int durationMinutes;
    @NotNull
    public double priceEconomy;
    @NotNull
    public double priceBusiness;
    @NotNull
    public double priceFirstClass;

}
