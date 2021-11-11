package nl.hu.prbed.airline.flight.application.filter;

import nl.hu.prbed.airline.flight.domain.Flight;

import java.util.ArrayList;
import java.util.List;

public class CriteriaDepartureLocation implements Criteria {
    @Override
    public List<Flight> meetCriteria(List<Flight> flights, Object criteria) {
        String departureLocation = (String) criteria;
        List<Flight> flightsWithDepartureLocation = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getRoute().getDepartureLocation().getCodeICAO().equals(departureLocation)) {
                flightsWithDepartureLocation.add(flight);
            }
        }
        return flightsWithDepartureLocation;
    }
}
