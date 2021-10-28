package nl.hu.prbed.vliegmaatschappij.domain;

public class FlightRoute {
    private Airport arrivalLocation;
    private Airport departureLocation;
    private Integer duration;

    private Double economyPrice;
    private Double businessPrice;
    private Double firstClassPrice;

    public FlightRoute(Airport arrivalLocation, Airport departureLocation, Integer duration, Double economyPrice, Double businessPrice, Double firstClassPrice){
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.duration = duration;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.firstClassPrice = firstClassPrice;
    }
}
