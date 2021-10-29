package nl.hu.prbed.vliegmaatschappij.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Airport {
    @Id
    @GeneratedValue
    @Column(length = 4, nullable = false)
    private Long id;
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

    public String getCode() {
        return code;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getCity() {
        return city;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
