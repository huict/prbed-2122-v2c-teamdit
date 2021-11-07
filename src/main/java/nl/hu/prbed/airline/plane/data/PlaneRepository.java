package nl.hu.prbed.airline.plane.data;


import nl.hu.prbed.airline.plane.domain.Plane;
import nl.hu.prbed.airline.plane.presentation.dto.PlaneRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
    Optional<Plane> findById(Long id);

    boolean existsByTypeAndSeatsBusinessAndSeatsEconomyAndSeatsFirstClass(String type,
                                                                          int seatsBusiness,
                                                                          int seatsEconomy,
                                                                          int seatsFirstClass);
}
