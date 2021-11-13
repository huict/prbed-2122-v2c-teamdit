package nl.hu.prbed.airline.plane.application;

import nl.hu.prbed.airline.airline.application.exception.InvalidDTOException;
import nl.hu.prbed.airline.fleet.application.FleetService;
import nl.hu.prbed.airline.fleet.application.FleetServiceImpl;
import nl.hu.prbed.airline.plane.application.exception.PlaneNotFoundException;
import nl.hu.prbed.airline.plane.application.exception.ReliantFlightsException;
import nl.hu.prbed.airline.plane.data.PlaneRepository;
import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneRequestDTO;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneResponseDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlaneServiceImpl implements PlaneService{
    private final PlaneRepository planeRepository;
    private final FleetService fleetService;

    public PlaneServiceImpl(PlaneRepository planeRepository, FleetServiceImpl fleetService) {
        this.planeRepository = planeRepository;
        this.fleetService = fleetService;
    }

    public PlaneResponseDTO addPlane(PlaneRequestDTO pro) {
       if (pro.type == null) {
            throw new InvalidDTOException("No type specified");
        }

        Plane plane = new Plane(pro.type, pro.seatsEconomy, pro.seatsBusiness, pro.seatsFirstClass);
        planeRepository.save(plane);

        fleetService.addPlane(plane);

        return new PlaneResponseDTO(plane);
    }

    public PlaneResponseDTO updatePlane(PlaneRequestDTO planeRequestDTO) {
        if (planeRequestDTO.id == null) {
            throw new InvalidDTOException("No ID specified");
        }

        try {
            Plane planeToUpdate = planeRepository.getById(planeRequestDTO.id);
            planeToUpdate.update(planeRequestDTO.type, planeRequestDTO.seatsEconomy, planeRequestDTO.seatsBusiness, planeRequestDTO.seatsFirstClass);

            planeRepository.saveAndFlush(planeToUpdate);
            return new PlaneResponseDTO(planeToUpdate);
        } catch (EntityNotFoundException e) {
            throw new PlaneNotFoundException(planeRequestDTO.id);
        }
    }

    public Plane getPlaneById(Long id) {
        return this.planeRepository.findById(id)
                .orElseThrow(() -> new PlaneNotFoundException(id));
    }

    public List<PlaneResponseDTO> getAllPlanes() {
        List<Plane> planes = this.planeRepository.findAll();
        List<PlaneResponseDTO> planeDTOS = new ArrayList<>();
        for (Plane plane : planes) {
            planeDTOS.add(new PlaneResponseDTO(plane));
        }
        return planeDTOS;
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
