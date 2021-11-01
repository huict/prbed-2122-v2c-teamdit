package nl.hu.prbed.airline.airline.presentation.dto;

import nl.hu.prbed.airline.airline.domain.Airport;
import nl.hu.prbed.airline.airline.domain.FlightRoute;

import javax.validation.constraints.NotNull;

public class FlightrouteDTO {

    @NotNull
    public Long id;
    @NotNull
    public Airport arrival;
    @NotNull
    public Airport departure;
    @NotNull
    public int durationMinutes;
    @NotNull
    public double priceEconomy;
    @NotNull
    public double priceBusiness;
    @NotNull
    public double priceFirstClass;

    public FlightrouteDTO() {

    }

    public FlightrouteDTO(FlightRoute flightRoute) {
        this.id = flightRoute.getId();
        this.arrival = flightRoute.getArrivalLocation();
        this.departure = flightRoute.getDepartureLocation();
        this.durationMinutes = flightRoute.getDurationMinutes();
        this.priceEconomy = flightRoute.getPriceEconomy();
        this.priceBusiness = flightRoute.getPriceBusiness();
        this.priceFirstClass = flightRoute.getPriceFirstClass();
    }

    public FlightRoute toFlightroute() {
        return new FlightRoute(arrival, departure, durationMinutes, priceEconomy, priceBusiness, priceFirstClass);
    }

}
