package nl.hu.prbed.vliegmaatschappij.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Time;


@Entity
public class Flight {

    private Integer id;

    private Time departureTime;
    private Time arrivalTime;

    private FlightRoute route;

    private Plane plane;

    public Flight(Time departureTime, Time arrivalTime, FlightRoute flightRoute, Plane plane){
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.route = flightRoute;
        this.plane = plane;
    }

}
