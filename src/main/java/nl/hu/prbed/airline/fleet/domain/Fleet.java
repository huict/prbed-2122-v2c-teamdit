package nl.hu.prbed.airline.fleet.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.hu.prbed.airline.plane.domain.Plane;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Fleet {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    private List<Plane> planes;

    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }
}
