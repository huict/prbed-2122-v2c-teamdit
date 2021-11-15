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

    public FlightRouteDTO(FlightRouteRequestDTO flightRouteRequestDTO) {
        if (flightRouteRequestDTO.id != null) {
            this.id = flightRouteRequestDTO.id;
        }
        this.arrivalCodeICAO = flightRouteRequestDTO.arrivalCodeICAO;
        this.departureCodeICAO = flightRouteRequestDTO.departureCodeICAO;
        this.durationMinutes = flightRouteRequestDTO.durationMinutes;
        this.priceEconomy = flightRouteRequestDTO.priceEconomy;
        this.priceBusiness = flightRouteRequestDTO.priceBusiness;
        this.priceFirstClass = flightRouteRequestDTO.priceFirstClass;
    }

    public FlightRoute toFlightroute(Airport arrival, Airport departure) {
        return new FlightRoute(arrival, departure, durationMinutes, priceEconomy, priceBusiness, priceFirstClass);
    }

    public FlightRoute toFlightroute(Long id, Airport arrival, Airport departure) {
        return new FlightRoute(id, arrival, departure, durationMinutes, priceEconomy, priceBusiness, priceFirstClass);
    }

}
