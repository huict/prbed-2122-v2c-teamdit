package nl.hu.prbed.airline.plane.presentation.dto;

import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;

public class PlaneDTO {
    public Long id;
    public String type;
    public int seatsEconomy;
    public int seatsBusiness;
    public int seatsFirstClass;

    public PlaneDTO() {
    }
}
