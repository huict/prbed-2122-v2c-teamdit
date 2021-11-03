package nl.hu.prbed.airline.airline.presentation.dto;

import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;

public class PlaneDTO {

    public String type;
    public Long id;
    public int seatsEconomy;
    public int seatsBusiness;
    public int seatsFirstClass;
}
