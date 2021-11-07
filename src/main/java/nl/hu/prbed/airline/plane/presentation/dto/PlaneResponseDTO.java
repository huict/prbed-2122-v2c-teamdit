package nl.hu.prbed.airline.plane.presentation.dto;

import nl.hu.prbed.airline.plane.domain.Plane;

public class PlaneResponseDTO {
    public Long id;
    public String type;
    public int seatsEconomy;
    public int seatsBusiness;
    public int seatsFirstClass;

    public PlaneResponseDTO() {
    }

    public PlaneResponseDTO(Plane plane) {
        this.id = plane.getId();
        this.type = plane.getType();
        this.seatsEconomy = plane.getSeatsEconomy();
        this.seatsBusiness = plane.getSeatsBusiness();
        this.seatsFirstClass = plane.getSeatsFirstClass();
    }
}
