package nl.hu.prbed.airline.plane.data;


import nl.hu.prbed.airline.plane.domain.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
    Optional<Plane> getPlaneById(Long id);
    List<Plane> findAll();
}
