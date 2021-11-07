package nl.hu.prbed.airline.airline.data;

import nl.hu.prbed.airline.airline.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
