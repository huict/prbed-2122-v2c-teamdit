package nl.hu.prbed.airline.security.data;

import nl.hu.prbed.airline.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
