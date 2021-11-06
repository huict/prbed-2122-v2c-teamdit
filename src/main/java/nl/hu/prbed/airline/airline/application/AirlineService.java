package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.NoAirlineExistsException;
import nl.hu.prbed.airline.airline.data.AirlineRepository;
import nl.hu.prbed.airline.airline.domain.Airline;
import nl.hu.prbed.airline.plane.application.PlaneService;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineService {
    private final AirlineRepository airlineRepository;
    private final PlaneService planeService;

    public AirlineService(AirlineRepository airlineRepository, PlaneService planeService){
        this.airlineRepository = airlineRepository;
        this.planeService = planeService;
    }

    public Airline getAirline(){
        try {
            return airlineRepository.findAll().get(0);
        }
        catch (IndexOutOfBoundsException e){
            throw new NoAirlineExistsException();
        }
    }

    public List<PlaneResponseDTO> addPlane(long id) {
        Plane plane = planeService.getPlaneById(id);
        Airline airline = getAirline();
        airline.addPlane(plane);

        airlineRepository.saveAndFlush(airline);

        List<PlaneResponseDTO> returnList = new ArrayList<>();

        airline.getFleet().forEach((plane1 -> returnList.add(new PlaneResponseDTO(plane1))));

        return returnList;
    }
}
