package nl.hu.prbed.airline.airline.domain;

import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.airline.domain.user.Employee;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@NoArgsConstructor
public class Airline {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Fleet fleet;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Flight> flights;

    public Airline(Fleet fleet, List<Employee> employees, List<Flight> flights) {
        this.fleet = fleet;
        this.employees = employees;
        this.flights = flights;
    }
}
