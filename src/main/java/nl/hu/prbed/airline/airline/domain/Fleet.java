package nl.hu.prbed.airline.airline.domain;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
public class Fleet {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Plane> planes;

    public Fleet() {
    }

    public Fleet(List<Plane> planes) {
        this.planes = planes;
    }
}
