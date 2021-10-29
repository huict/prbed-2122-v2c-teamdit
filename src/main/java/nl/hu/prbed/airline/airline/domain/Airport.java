package nl.hu.prbed.airline.airline.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Airport {
    @Id
    @Column(length = 4, nullable = false)
    private String code;
    private String airportName;
    private String city;
    private String country;
    private double longitude;
    private double latitude;

    public Airport() {
    }

    public Airport(String code, String airportName, String city, String country, double longitude, double latitude) {
        this.code = code;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

}
