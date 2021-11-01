package nl.hu.prbed.airline.airline.domain;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import org.hibernate.annotations.CascadeType;

import java.util.List;


@Component
@Entity
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

    public FlightRoute() {

    }

    public FlightRoute(Long id, Airport departureLocation, Airport arrivalLocation, Integer durationMinutes, Double priceEconomy, Double priceBusiness, Double priceFirstClass) {
        this.id = id;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.durationMinutes = durationMinutes;
        this.priceEconomy = priceEconomy;
        this.priceBusiness = priceBusiness;
        this.priceFirstClass = priceFirstClass;
    }

    public FlightRoute(Airport departureLocation, Airport arrivalLocation, Integer durationMinutes, Double priceEconomy, Double priceBusiness, Double priceFirstClass){
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.durationMinutes = durationMinutes;
        this.priceEconomy = priceEconomy;
        this.priceBusiness = priceBusiness;
        this.priceFirstClass = priceFirstClass;
    }

    public Long getId() {
        return id;
    }

    public Airport getDepartureLocation() {
        return departureLocation;
    }

    public Airport getArrivalLocation() {
        return arrivalLocation;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public Double getPriceEconomy() {
        return priceEconomy;
    }

    public Double getPriceBusiness() {
        return priceBusiness;
    }

    public Double getPriceFirstClass() {
        return priceFirstClass;
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

    @Override
    public String toString() {
        return "FlightRoute{" +
                "id=" + id +
                ", departureLocation=" + departureLocation +
                ", arrivalLocation=" + arrivalLocation +
                ", durationMinutes=" + durationMinutes +
                ", priceEconomy=" + priceEconomy +
                ", priceBusiness=" + priceBusiness +
                ", priceFirstClass=" + priceFirstClass +
                '}';
    }
}
