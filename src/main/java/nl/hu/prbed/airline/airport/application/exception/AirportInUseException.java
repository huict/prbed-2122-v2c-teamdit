package nl.hu.prbed.airline.airport.application.exception;

public class AirportInUseException extends RuntimeException {
    public AirportInUseException(String codeICAO) {
        super("Airport still in use in a flightRoute, airport ICAO: " + codeICAO);
    }
}
