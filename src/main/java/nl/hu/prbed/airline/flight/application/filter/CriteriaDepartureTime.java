package nl.hu.prbed.airline.flight.application.filter;

import nl.hu.prbed.airline.flight.domain.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriteriaDepartureTime implements Criteria {
    @Override
    public List<Flight> meetCriteria(List<Flight> flights, Object criteria) {
        LocalDateTime departureTime = (LocalDateTime) criteria;
        List<Flight> flightsWithDepartureTime = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getDepartureTime().equals(departureTime)) {
                flightsWithDepartureTime.add(flight);
            }
        }
        return flightsWithDepartureTime;
    }
}
