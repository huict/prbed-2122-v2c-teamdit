package nl.hu.prbed.airline.airline.domain;

import nl.hu.prbed.airline.airline.presentation.dto.PlaneDTO;
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

    public void update(String type, int seatsEconomy, int seatsBusiness, int seatsFirstClass){
        this.type = type;
        this.seatsEconomy = seatsEconomy;
        this.seatsBusiness = seatsBusiness;
        this.seatsFirstClass = seatsFirstClass;
    }

    public Plane(String type, int seatsEconomy, int seatsBusiness, int seatsFirstClass) {
        this.type = type;
        this.seatsEconomy = seatsEconomy;
        this.seatsBusiness = seatsBusiness;
        this.seatsFirstClass = seatsFirstClass;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getSeatsBusiness() {
        return seatsBusiness;
    }

    public int getSeatsEconomy() {
        return seatsEconomy;
    }

    public int getSeatsFirstClass() {
        return seatsFirstClass;
    }

    public int getTotalSeats(){return seatsBusiness + seatsEconomy + seatsFirstClass;}
}
