package nl.hu.prbed.airline.airport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Component
@NoArgsConstructor
@Getter
public class Airport {
    @Id
    @Column(length = 4, nullable = false)
    private String codeICAO;
    private String airportName;
    private String city;
    private String country;
    private double longitude;
    private double latitude;

    public Airport(String codeICAO, String airportName, String city, String country, double longitude, double latitude) {
        this.codeICAO = codeICAO.toUpperCase(Locale.ROOT);
        this.airportName = airportName;
        this.city = city;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
