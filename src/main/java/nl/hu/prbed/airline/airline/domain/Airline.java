package nl.hu.prbed.airline.airline.domain;

import nl.hu.prbed.airline.airline.domain.user.Employee;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
public class Airline {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Plane> fleet;

    public Airline() {

    }

    public Airline(List<Employee> employees) {
        this.employees = employees;
    }
}
