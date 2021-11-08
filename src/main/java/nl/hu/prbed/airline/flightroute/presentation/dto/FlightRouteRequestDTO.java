package nl.hu.prbed.airline.flightroute.presentation.dto;

import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
public class FlightRouteRequestDTO {
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
