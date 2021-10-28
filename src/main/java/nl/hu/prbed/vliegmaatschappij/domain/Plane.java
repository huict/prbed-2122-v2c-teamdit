package nl.hu.prbed.vliegmaatschappij.domain;

public class Plane {
    private String type;
    private int seatsEconomy;
    private int seatsBusiness;
    private int seatsFirstClass;
    private boolean inUse;

    public Plane(String type, int seatsEconomy, int seatsBusiness, int seatsFirstClass, boolean inUse) {
        this.type = type;
        this.seatsEconomy = seatsEconomy;
        this.seatsBusiness = seatsBusiness;
        this.seatsFirstClass = seatsFirstClass;
        this.inUse = inUse;
    }
}
