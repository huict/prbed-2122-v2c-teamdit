package nl.hu.prbed.airline.booking.domain;

public enum BookingClass {
    ECONOMY("ECONOMY"),
    BUSINESS("BUSINESS"),
    FIRST("FIRST");

    private String label;

    BookingClass(String label) {
        this.label = label;
    }
}