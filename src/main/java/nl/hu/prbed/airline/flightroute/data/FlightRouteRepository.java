package nl.hu.prbed.airline.flightroute.data;


import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.flightroute.domain.FlightRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRouteRepository extends JpaRepository<FlightRoute,Long> {
    List<FlightRoute> findAll();
    boolean existsById(Long id);
    boolean existsByDepartureLocationAndArrivalLocationAndDurationMinutesAndPriceEconomyAndPriceBusinessAndPriceFirstClass(Airport departureLocationCode, Airport arrivalLocationCode, int durationMinutes, double priceEconomy, double priceBusiness, double priceFirstClass);
    Optional<FlightRoute> findByDepartureLocationAndArrivalLocationAndDurationMinutesAndPriceEconomyAndPriceBusinessAndPriceFirstClass(Airport departureLocationCode, Airport arrivalLocationCode, int durationMinutes, double priceEconomy, double priceBusiness, double priceFirstClass);
    List<FlightRoute> findAllByArrivalLocation(Airport arrivalLocation);
    List<FlightRoute> findAllByDepartureLocation(Airport departureLocation);
}
