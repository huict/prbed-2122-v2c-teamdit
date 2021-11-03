package nl.hu.prbed.airline.airline.application;

import nl.hu.prbed.airline.airline.application.exception.InvalidDTOException;
import nl.hu.prbed.airline.airline.application.exception.PlaneNotFoundException;
import nl.hu.prbed.airline.airline.application.exception.ReliantFlightsException;
import nl.hu.prbed.airline.airline.data.PlaneRepository;
import nl.hu.prbed.airline.airline.domain.Plane;
import nl.hu.prbed.airline.airline.presentation.dto.PlaneDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class PlaneService {

    private PlaneRepository repository;

    public PlaneService(PlaneRepository repository){this.repository = repository;}

    public Plane updatePlane(PlaneDTO dto){
        if(dto.id == null){
            throw new InvalidDTOException("no ID specified!");
        }
        try {
            Plane planeToUpdate = repository.getById(dto.id);
            planeToUpdate.update(dto.type, dto.seatsEconomy, dto.seatsBusiness, dto.seatsFirstClass);
            repository.saveAndFlush(planeToUpdate);
            return planeToUpdate;
        }
        catch (EntityNotFoundException e){
            throw new PlaneNotFoundException(dto.id);
        }
    }

    public Plane getPlane(PlaneDTO dto){
        if(dto.id == null){
            throw new InvalidDTOException("no ID specified!");
        }
        try {
            return repository.getById(dto.id);
        }
        catch(EntityNotFoundException e){
            throw new PlaneNotFoundException(dto.id);
        }
    }

    public Plane getPlane(Long id){
        try {
            return repository.getById(id);
        }
        catch(EntityNotFoundException e){
            throw new PlaneNotFoundException(id);
        }
    }

    public List<Plane> getAllPlanes(){
        return repository.findAll();
    }

    public Boolean deletePlane(PlaneDTO dto) {
        Plane planeToDelete = getPlane(dto);
        if (planeToDelete == null) {
            throw new PlaneNotFoundException(dto.id);
        }
        try {
            repository.delete(planeToDelete);
            return true;
        } catch (ConstraintViolationException e) {
            throw new ReliantFlightsException("this plane still has flights!");
        }
    }
}
