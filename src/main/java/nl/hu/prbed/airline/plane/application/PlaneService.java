package nl.hu.prbed.airline.plane.application;

import nl.hu.prbed.airline.airline.application.exception.InvalidDTOException;
import nl.hu.prbed.airline.plane.application.exception.PlaneNotFoundException;
import nl.hu.prbed.airline.plane.application.exception.ReliantFlightsException;
import nl.hu.prbed.airline.plane.data.PlaneRepository;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class PlaneService {

    private PlaneRepository planeRepository;

    public PlaneService(PlaneRepository planeRepository){this.planeRepository = planeRepository;}

    public Plane updatePlane(PlaneDTO dto){
        if(dto.id == null){
            throw new InvalidDTOException("no ID specified!");
        }
        try {
            Plane planeToUpdate = planeRepository.getById(dto.id);
            planeToUpdate.update(dto.type, dto.seatsEconomy, dto.seatsBusiness, dto.seatsFirstClass);
            planeRepository.saveAndFlush(planeToUpdate);
            return planeToUpdate;
        }
        catch (EntityNotFoundException e){
            throw new PlaneNotFoundException(dto.id);
        }
    }

    public Plane getPlaneById(Long id){
        return this.planeRepository.findById(id)
                .orElseThrow(() -> new PlaneNotFoundException(id));
    }

    public List<Plane> getAllPlanes(){
        return planeRepository.findAll();
    }

    public Boolean deletePlane(Long id) {
        Plane planeToDelete = getPlaneById(id);

        try {
            planeRepository.delete(planeToDelete);
            return true;
        } catch (ConstraintViolationException e) {
            throw new ReliantFlightsException("this plane still has flights!");
        }
    }
}