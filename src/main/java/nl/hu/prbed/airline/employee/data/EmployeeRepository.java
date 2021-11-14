package nl.hu.prbed.airline.employee.data;

import nl.hu.prbed.airline.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
    boolean existsByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth);
}
