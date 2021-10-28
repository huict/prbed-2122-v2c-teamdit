package nl.hu.prbed.vliegmaatschappij.domain;

public class FlightRoutes {
    private Airport arrivalLocation;
    private Airport departureLocation;
    private Integer duration;
    private float economyPrice;
    private float businessPrice;
    private float firstClassPrice;

    public FlightRoutes(Airport arrivalLocation, Airport departureLocation, Integer duration, float economyPrice, float businessPrice, float firstClassPrice){
        this.arrivalLocation = arrivalLocation;
        this.departureLocation = departureLocation;
        this.duration = duration;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.firstClassPrice = firstClassPrice;
    }
}
