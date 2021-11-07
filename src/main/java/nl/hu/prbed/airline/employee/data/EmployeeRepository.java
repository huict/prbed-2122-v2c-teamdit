package nl.hu.prbed.airline.employee.data;

import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
