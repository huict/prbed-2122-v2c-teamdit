package nl.hu.prbed.vliegmaatschappij.domain;

import javax.persistence.*;

@Entity
@Table(name = "AIRPORT")
public class Airport {
    @Id
    @Column(name = "CODE", length = 4, nullable = false)
    private String code;

    @Column(name = "AIRPORT_NAME")
    private String airportName;

    @Column(name = "CITY")
    private String city;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "LATITUDE")
    private double latitude;

    public Airport() {
    }

    public Airport(String code, String airportName, String city, double longitude, double latitude) {
        this.code = code;
        this.airportName = airportName;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
