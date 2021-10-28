package nl.hu.prbed.vliegmaatschappij.domain;

import java.util.List;

public class Airline {
    private List<Employee> employees;
    // todo: planes here?
    private List<Plane> fleet;

    public Airline(List<Employee> employees) {
        this.employees = employees;
    }
}
