package nl.hu.prbed.airline.plane.presentation.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlaneDTO {
    public Long id;
    public String type;
    public int seatsEconomy;
    public int seatsBusiness;
    public int seatsFirstClass;
}
