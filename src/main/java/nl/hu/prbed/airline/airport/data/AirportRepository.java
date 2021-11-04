package nl.hu.prbed.airline.airport.data;


import nl.hu.prbed.airline.airport.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport,Long> {
    Optional<Airport> findByCode(String code);
    void deleteByCode(String code);
    boolean existsByCode(String code);
}