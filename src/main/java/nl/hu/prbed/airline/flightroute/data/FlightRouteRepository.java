package nl.hu.prbed.airline.flightroute.data;



import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRouteRepository extends JpaRepository<FlightRoute,Long> {
    List<FlightRoute> findAll();

}
