package nl.hu.prbed.airline.fleet.domain;

import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.plane.domain.Plane;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@NoArgsConstructor
public class Fleet {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Plane> planes;

    public Fleet(List<Plane> planes) {
        this.planes = planes;
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }
}
