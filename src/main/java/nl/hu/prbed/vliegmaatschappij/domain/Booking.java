package nl.hu.prbed.vliegmaatschappij.domain;

public class Booking {

    private int id;

    public Booking(int id, Class bookingClass, Customer customer){
        this.id = id;
        this.bookingClass = bookingClass;
        this.customer = customer;
    }

    private Class bookingClass;
    private Customer customer;
}
