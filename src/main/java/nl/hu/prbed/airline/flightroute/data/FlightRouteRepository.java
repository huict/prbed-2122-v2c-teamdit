package nl.hu.prbed.airline.flightroute.data;


import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRouteRepository extends JpaRepository<FlightRoute,Long> {
    List<FlightRoute> findAll();
    boolean existsById(Long id);
    boolean existsByDepartureLocationAndArrivalLocationAndDurationMinutesAndPriceEconomyAndPriceBusinessAndPriceFirstClass(Airport departure_location_code, Airport arrival_location_code, int duration_minutes, double price_economy, double price_business, double price_first_class);
    Optional<FlightRoute> findByDepartureLocationAndArrivalLocationAndDurationMinutesAndPriceEconomyAndPriceBusinessAndPriceFirstClass(Airport departure_location_code, Airport arrival_location_code, int duration_minutes, double price_economy, double price_business, double price_first_class);
    List<FlightRoute> findAllByArrivalLocation(Airport arrivalLocation);
    List<FlightRoute> findAllByDepartureLocation(Airport departureLocation);
}
