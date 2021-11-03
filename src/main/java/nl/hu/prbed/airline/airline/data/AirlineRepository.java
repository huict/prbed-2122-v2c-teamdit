package nl.hu.prbed.airline.airline.data;

import nl.hu.prbed.airline.airline.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    public List<Airline> findAll();
}
