package nl.hu.prbed.airline.flightroute.presentation.dto;

import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class FlightRouteDTO {

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

    public FlightRouteDTO(FlightRoute flightRoute) {
        this.id = flightRoute.getId();
        this.arrivalCodeICAO = flightRoute.getArrivalLocation().getCodeICAO();
        this.departureCodeICAO = flightRoute.getDepartureLocation().getCodeICAO();
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
