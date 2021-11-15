package nl.hu.prbed.airline.flightroute.presentation.dto;

import nl.hu.prbed.airline.flightroute.domain.FlightRoute;

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

    public FlightRouteResponseDTO(FlightRoute flightRoute) {
        this.id = flightRoute.getId();
        this.arrivalCodeICAO = flightRoute.getArrivalLocation().getCodeICAO();
        this.departureCodeICAO = flightRoute.getDepartureLocation().getCodeICAO();
        this.durationMinutes = flightRoute.getDurationMinutes();
        this.priceEconomy = flightRoute.getPriceEconomy();
        this.priceBusiness = flightRoute.getPriceBusiness();
        this.priceFirstClass = flightRoute.getPriceFirstClass();
    }
}
