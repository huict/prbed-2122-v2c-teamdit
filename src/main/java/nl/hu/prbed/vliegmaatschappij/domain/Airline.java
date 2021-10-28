package nl.hu.prbed.vliegmaatschappij.domain;

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
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Employee> employees;

    // todo: planes here?
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Plane> planes;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Plane> fleet;

    public Airline() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airline(List<Employee> employees) {
        this.employees = employees;
    }
}
