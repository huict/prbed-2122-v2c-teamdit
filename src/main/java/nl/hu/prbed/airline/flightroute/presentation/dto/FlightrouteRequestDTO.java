package nl.hu.prbed.airline.flightroute.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
public class FlightrouteRequestDTO {
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
