package nl.hu.prbed.airline.flight.application.filter;

import nl.hu.prbed.airline.flight.domain.Flight;

import java.util.List;

public interface Criteria {
    List<Flight> meetCriteria(List<Flight> flights, Object criteria);
}
