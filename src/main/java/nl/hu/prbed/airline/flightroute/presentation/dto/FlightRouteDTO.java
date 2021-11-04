package nl.hu.prbed.airline.flightroute.presentation.dto;

import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;

import javax.validation.constraints.NotNull;

public class FlightRouteDTO {

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

    public FlightRouteDTO() {

    }

    public FlightRouteDTO(FlightRoute flightRoute) {
        this.id = flightRoute.getId();
        this.arrivalCode = flightRoute.getArrivalLocation().getCode();
        this.departureCode = flightRoute.getDepartureLocation().getCode();
        this.durationMinutes = flightRoute.getDurationMinutes();
        this.priceEconomy = flightRoute.getPriceEconomy();
        this.priceBusiness = flightRoute.getPriceBusiness();
        this.priceFirstClass = flightRoute.getPriceFirstClass();
    }

    public FlightRoute toFlightroute(Airport arrival, Airport departure) {
        return new FlightRoute(arrival, departure, durationMinutes, priceEconomy, priceBusiness, priceFirstClass);
    }

    public FlightRoute toFlightroute(Long id, Airport arrival, Airport departure) {
        return new FlightRoute(id, arrival, departure, durationMinutes, priceEconomy, priceBusiness, priceFirstClass);
    }

}
