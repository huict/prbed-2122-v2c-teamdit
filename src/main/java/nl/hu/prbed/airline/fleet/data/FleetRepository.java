package nl.hu.prbed.airline.fleet.data;

import nl.hu.prbed.airline.fleet.domain.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FleetRepository extends JpaRepository<Fleet, Long> {
}
