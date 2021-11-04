package nl.hu.prbed.airline.plane.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Component
@NoArgsConstructor
@Getter
public class Plane {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String type;
    private int seatsEconomy;
    private int seatsBusiness;
    private int seatsFirstClass;

    public Plane(String type, int seatsEconomy, int seatsBusiness, int seatsFirstClass) {
        this.type = type;
        this.seatsEconomy = seatsEconomy;
        this.seatsBusiness = seatsBusiness;
        this.seatsFirstClass = seatsFirstClass;
    }

    public void update(String type, int seatsEconomy, int seatsBusiness, int seatsFirstClass) {
        this.type = type;
        this.seatsEconomy = seatsEconomy;
        this.seatsBusiness = seatsBusiness;
        this.seatsFirstClass = seatsFirstClass;
    }

    public int getTotalSeats() {
        return seatsBusiness + seatsEconomy + seatsFirstClass;
    }

}
