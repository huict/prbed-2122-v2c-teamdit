package nl.hu.prbed.airline.airline.data;

import nl.hu.prbed.airline.airline.domain.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FleetRepository extends JpaRepository<Fleet, Long> {
    public List<Fleet> findAll();
}
