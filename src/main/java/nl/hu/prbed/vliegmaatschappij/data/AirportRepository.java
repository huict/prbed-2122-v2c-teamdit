package nl.hu.prbed.vliegmaatschappij.data;


import nl.hu.prbed.vliegmaatschappij.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport,Long> {
    Optional<Airport> findByCode(String code);
    Airport deleteAirportByCode(String code);
}
