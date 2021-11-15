package nl.hu.prbed.airline.flightroute.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
public class FlightRouteRequestDTO {
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
