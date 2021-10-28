package nl.hu.prbed.vliegmaatschappij.domain;

public class Airport {
    private String airportName;
    private String city;
    private String code;
    private double longditude;
    private double latitude;

    public Airport(String airportName, String city, String code, double longditude, double latitude) {
        this.airportName = airportName;
        this.city = city;
        this.code = code;
        this.longditude = longditude;
        this.latitude = latitude;
    }
}
