package nl.hu.prbed.airline.flight.application.filter;

import nl.hu.prbed.airline.flight.domain.Flight;

import java.util.ArrayList;
import java.util.List;

public class CriteriaArrivalLocation implements Criteria {
    @Override
    public List<Flight> meetCriteria(List<Flight> flights, Object criteria) {
        String arrivalLocation = (String) criteria;
        List<Flight> flightsWithArrivalLocationLocation = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getRoute().getArrivalLocation().getCodeICAO().equals(arrivalLocation)) {
                flightsWithArrivalLocationLocation.add(flight);
            }
        }
        return flightsWithArrivalLocationLocation;
    }
}
