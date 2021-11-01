package nl.hu.prbed.airline.airline.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import nl.hu.prbed.airline.airline.domain.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDTO  {
    public Long flightRouteId;
    public Long planeId;

//    public List<Long> bookingIds;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public LocalDateTime departureTime;



    public FlightDTO(LocalDateTime departureTime, Long flightRouteId, Long planeId) {
        this.departureTime = departureTime;
        this.flightRouteId = flightRouteId;
        this.planeId = planeId;
    }




}
