package nl.hu.prbed.airline.airline.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Component
public class Plane {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String type;
    private int seatsEconomy;
    private int seatsBusiness;
    private int seatsFirstClass;

    public Plane() {

    }

    public Plane(String type, int seatsEconomy, int seatsBusiness, int seatsFirstClass) {
        this.type = type;
        this.seatsEconomy = seatsEconomy;
        this.seatsBusiness = seatsBusiness;
        this.seatsFirstClass = seatsFirstClass;
    }
}
