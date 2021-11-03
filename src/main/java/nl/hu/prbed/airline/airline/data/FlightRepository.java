package nl.hu.prbed.airline.airline.data;

import nl.hu.prbed.airline.airline.domain.Flight;
import nl.hu.prbed.airline.airline.domain.FlightRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    Optional<Flight> findByRouteAndDepartureTime(FlightRoute route, Date departureTime);
    List<Flight> findAllByDepartureTime(Date departure);
    void deleteByDepartureTimeAndRoute(Date departureTime,FlightRoute route);
    void deleteById(Long id);

}