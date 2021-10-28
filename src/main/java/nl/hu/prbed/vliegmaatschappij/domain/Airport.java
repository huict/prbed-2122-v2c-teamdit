package nl.hu.prbed.vliegmaatschappij.domain;

import javax.persistence.*;

@Entity
@Table(name = "AIRPORT")
public class Airport {
    @Id
    @Column(length = 4, nullable = false)
    private String code;
    private String airportName;
    private String city;
    private double longitude;
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
