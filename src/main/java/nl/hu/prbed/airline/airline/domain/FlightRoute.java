package nl.hu.prbed.airline.airline.domain;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import org.hibernate.annotations.CascadeType;


@Component
@Entity
public class FlightRoute {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Airport departureLocation;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Airport arrivalLocation;

    private Integer durationMinutes;
    private Double priceEconomy;
    private Double priceBusiness;
    private Double priceFirstClass;

    public FlightRoute() {

    }

    public FlightRoute(Airport departureLocation, Airport arrivalLocation, Integer durationMinutes, Double priceEconomy, Double priceBusiness, Double priceFirstClass){
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.durationMinutes = durationMinutes;
        this.priceEconomy = priceEconomy;
        this.priceBusiness = priceBusiness;
        this.priceFirstClass = priceFirstClass;
    }
}
