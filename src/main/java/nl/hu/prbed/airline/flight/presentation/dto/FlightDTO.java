package nl.hu.prbed.airline.flight.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import nl.hu.prbed.airline.airline.domain.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class FlightDTO {

    public Long flightRouteId;
    public Long planeId;
    public LocalDateTime departureTime;
    public Long bookingId;
    public Long flightId;

    public FlightDTO(LocalDateTime departureTime, Long flightRouteId, Long planeId) {
        this.departureTime = departureTime;
        this.flightRouteId = flightRouteId;
        this.planeId = planeId;
    }

}
