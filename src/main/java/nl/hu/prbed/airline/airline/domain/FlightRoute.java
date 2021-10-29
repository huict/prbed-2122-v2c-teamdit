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
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Airport arrivalLocation;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Airport departureLocation;
    private Integer duration;
    private Double economyPrice;
    private Double businessPrice;
    private Double firstClassPrice;

    public FlightRoute() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightRoute(Airport arrivalLocation, Airport departureLocation, Integer duration, Double economyPrice, Double businessPrice, Double firstClassPrice){
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.duration = duration;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.firstClassPrice = firstClassPrice;
    }
}
