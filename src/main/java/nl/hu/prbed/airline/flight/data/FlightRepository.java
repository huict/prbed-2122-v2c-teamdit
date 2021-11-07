package nl.hu.prbed.airline.flight.data;

import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.flight.domain.Flight;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FlightRepository extends JpaRepository<Flight,Long> {
    Optional<Flight> findByRouteAndDepartureTime(FlightRoute route, LocalDateTime departureTime);
    List<Flight> findAllByDepartureTime(LocalDateTime departure);

    void deleteById(Long id);

    Optional<Flight> findByRoute(FlightRoute arrival);


}
