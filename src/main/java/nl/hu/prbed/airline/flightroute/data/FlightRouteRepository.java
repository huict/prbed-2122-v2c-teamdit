package nl.hu.prbed.airline.flightroute.data;



import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRouteRepository extends JpaRepository<FlightRoute,Long> {
    List<FlightRoute> findAll();
    boolean existsById(Long id);
    boolean existsByDepartureLocationAndArrivalLocationAndDurationMinutesAndPriceEconomyAndPriceBusinessAndPriceFirstClass(String departure, String arrival, int minutes, double economy, double business, double firstClass);
    Optional<FlightRoute> findByDepartureLocationAndArrivalLocationAndDurationMinutesAndPriceEconomyAndPriceBusinessAndPriceFirstClass(String departure, String arrival, int minutes, double economy, double business, double firstClass);
}
