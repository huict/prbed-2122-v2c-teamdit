package nl.hu.prbed.airline.security;

import nl.hu.prbed.airline.airline.data.AirlineRepository;
import nl.hu.prbed.airline.airline.domain.Airline;
import nl.hu.prbed.airline.fleet.domain.Fleet;
import nl.hu.prbed.airline.security.data.RoleRepository;
import nl.hu.prbed.airline.security.data.UserRepository;
import nl.hu.prbed.airline.security.domain.Role;
import nl.hu.prbed.airline.security.domain.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import java.util.ArrayList;

import static nl.hu.prbed.airline.security.domain.Role.getAllRoleNames;

@Component
@Transactional
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private boolean alreadySetup = false;

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AirlineRepository airlineRepository;
    private static final String admin = "admin";
    private static final String employee = "employee";

    public SetupDataLoader(RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, AirlineRepository airlineRepository) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.airlineRepository = airlineRepository;
    }

    // Temporary replacement for this being a non-production environment
    // and there being no better alternative for adding these data entries
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        for (String roleName : getAllRoleNames()) {
            createRoleIfNotFound(roleName);
        }

        if (!userRepository.existsByUsername(admin)) {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            User user = new User(admin, passwordEncoder.encode(admin), "Ad", "Min");
            user.addRole(adminRole);
            userRepository.save(user);
        }


        if (!userRepository.existsByUsername(employee)) {
            Role employeeRole = roleRepository.findByName("ROLE_EMPLOYEE");
            User user = new User(employee, passwordEncoder.encode(employee), "emplo", "yee");
            user.addRole(employeeRole);
            userRepository.save(user);
        }

        if (airlineRepository.findAll().size() != 1) {
            Fleet fleet = new Fleet();
            Airline airline = new Airline(fleet, new ArrayList<>(), new ArrayList<>());

            airlineRepository.save(airline);
        }

        alreadySetup = true;
    }

    private Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
