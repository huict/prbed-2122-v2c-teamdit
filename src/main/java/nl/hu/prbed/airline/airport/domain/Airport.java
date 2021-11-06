package nl.hu.prbed.airline.airport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
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
}
