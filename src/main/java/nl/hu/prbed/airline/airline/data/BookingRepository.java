package nl.hu.prbed.airline.airline.data;

import nl.hu.prbed.airline.airline.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository  extends JpaRepository<Booking,Long> {
    Optional<Booking> findByid(Long id);
    void deleteById(Long id);
}