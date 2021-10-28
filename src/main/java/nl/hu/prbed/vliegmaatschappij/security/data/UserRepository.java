package nl.hu.prbed.vliegmaatschappij.security.data;

import nl.hu.prbed.vliegmaatschappij.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This is a magic interface, which is automatically implemented
 * by Spring based on the chosen nl.hu.prbed.vliegmaatschappij.data storage configuration
 * when the nl.hu.prbed.vliegmaatschappij.application is started.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}