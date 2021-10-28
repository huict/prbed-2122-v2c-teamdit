package nl.hu.prbed.vliegmaatschappij.domain;


import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class Flight {

    private Integer id;

    private List<Booking> bookings = new ArrayList<Booking>();

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
