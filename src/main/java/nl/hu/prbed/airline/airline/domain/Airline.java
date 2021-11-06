package nl.hu.prbed.airline.airline.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.employee.domain.Employee;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.plane.domain.Plane;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@NoArgsConstructor
@Getter
public class Airline {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Plane> fleet;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Flight> flights;

    public Airline(List<Plane> fleet, List<Employee> employees, List<Flight> flights) {
        this.fleet = fleet;
        this.employees = employees;
        this.flights = flights;
    }

    public void addPlane(Plane plane) {
        this.fleet.add(plane);
    }
}
