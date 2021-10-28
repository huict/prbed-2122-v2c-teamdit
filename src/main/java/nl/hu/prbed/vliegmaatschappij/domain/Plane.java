package nl.hu.prbed.vliegmaatschappij.domain;

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
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;
    private int seatsEconomy;
    private int seatsBusiness;
    private int seatsFirstClass;
    private boolean inUse;

    public Plane() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plane(String type, int seatsEconomy, int seatsBusiness, int seatsFirstClass, boolean inUse) {
        this.type = type;
        this.seatsEconomy = seatsEconomy;
        this.seatsBusiness = seatsBusiness;
        this.seatsFirstClass = seatsFirstClass;
        this.inUse = inUse;
    }
}
