package nl.hu.prbed.airline.flightroute.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.airport.domain.Airport;
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

}
