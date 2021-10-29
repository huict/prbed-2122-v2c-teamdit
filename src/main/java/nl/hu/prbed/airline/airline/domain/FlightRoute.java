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

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Airport departureLocation;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Airport arrivalLocation;

    private Integer duration;
    private Double economyPrice;
    private Double businessPrice;
    private Double firstClassPrice;

    public FlightRoute() {

    }

    public FlightRoute(Airport departureLocation, Airport arrivalLocation, Integer duration, Double economyPrice, Double businessPrice, Double firstClassPrice){
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.duration = duration;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.firstClassPrice = firstClassPrice;
    }
}
