package nl.hu.prbed.airline.airline.domain;


import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Component
public class Flight {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    private LocalDateTime departureTime;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private FlightRoute route;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Plane plane;

    public Flight() {

    }

    public Flight(LocalDateTime  departureTime, FlightRoute flightRoute, Plane plane){
        this.departureTime = departureTime;
        this.route = flightRoute;
        this.plane = plane;
    }

}
