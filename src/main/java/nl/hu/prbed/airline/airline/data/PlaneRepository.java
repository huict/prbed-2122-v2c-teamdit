package nl.hu.prbed.airline.airline.data;


import nl.hu.prbed.airline.airline.domain.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
    public Optional<Plane> getPlaneById(Long id);
    public List<Plane> findAll();
}
