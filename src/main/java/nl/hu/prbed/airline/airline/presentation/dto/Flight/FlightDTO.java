package nl.hu.prbed.airline.airline.presentation.dto.Flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import nl.hu.prbed.airline.airline.domain.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class FlightDTO {

    public Long flightRouteId;
    public Long planeId;
    public Date departureTime;

    public FlightDTO(Date departureTime, Long flightRouteId, Long planeId) {
        this.departureTime = departureTime;
        this.flightRouteId = flightRouteId;
        this.planeId = planeId;
    }

}
