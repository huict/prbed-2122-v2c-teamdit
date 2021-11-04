package nl.hu.prbed.airline.customer.data;

import nl.hu.prbed.airline.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByid(Long id);
}
