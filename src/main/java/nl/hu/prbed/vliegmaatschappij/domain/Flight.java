package nl.hu.prbed.vliegmaatschappij.domain;


import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Entity
@Component
public class Flight {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();
    private Time departureTime;
    private Time arrivalTime;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private FlightRoute route;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Plane plane;

    public Flight() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight(Time departureTime, Time arrivalTime, FlightRoute flightRoute, Plane plane){
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.route = flightRoute;
        this.plane = plane;
    }

}
