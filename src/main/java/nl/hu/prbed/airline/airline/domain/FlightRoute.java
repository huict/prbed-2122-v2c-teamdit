package nl.hu.prbed.airline.airline.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FlightRoute {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    private Airport departureLocation;

    @ManyToOne
    private Airport arrivalLocation;

    private Integer durationMinutes;
    private Double priceEconomy;
    private Double priceBusiness;
    private Double priceFirstClass;

    public FlightRoute(Airport departureLocation, Airport arrivalLocation, Integer durationMinutes, Double priceEconomy, Double priceBusiness, Double priceFirstClass){
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.durationMinutes = durationMinutes;
        this.priceEconomy = priceEconomy;
        this.priceBusiness = priceBusiness;
        this.priceFirstClass = priceFirstClass;
    }

    public Object flightExists(List<FlightRoute> flightRoutes, FlightRoute flightRoute) {
        for (FlightRoute flightRouteRepo : flightRoutes) {
            if (flightRoute.getArrivalLocation().equals(flightRouteRepo.getArrivalLocation()) &&
                    flightRoute.getDepartureLocation().equals(flightRouteRepo.getDepartureLocation()) &&
                    flightRoute.getDurationMinutes().equals(flightRouteRepo.getDurationMinutes()) &&
                    flightRoute.getPriceEconomy().equals(flightRouteRepo.getPriceEconomy()) &&
                    flightRoute.getPriceBusiness().equals(flightRouteRepo.getPriceBusiness()) &&
                    flightRoute.getPriceFirstClass().equals(flightRouteRepo.getPriceFirstClass())) {
                return flightRouteRepo;
            }
        }
        return false;
    }
}
