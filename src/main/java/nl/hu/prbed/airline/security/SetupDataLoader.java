package nl.hu.prbed.airline.security;

import nl.hu.prbed.airline.security.data.RoleRepository;
import nl.hu.prbed.airline.security.data.UserRepository;
import nl.hu.prbed.airline.security.domain.Role;
import nl.hu.prbed.airline.security.domain.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import static nl.hu.prbed.airline.security.domain.Role.getAllRoleNames;

@Component
@Transactional
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private boolean alreadySetup = false;

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public SetupDataLoader(RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        for (String roleName : getAllRoleNames()) {
            createRoleIfNotFound(roleName);
        }

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        if (!userRepository.existsByUsername("admin")) {
            User user = new User("admin", passwordEncoder.encode("admin"), "Ad", "Min");
            user.addRole(adminRole);
            userRepository.save(user);
        }

        Role employeeRole = roleRepository.findByName("ROLE_EMPLOYEE");

        if (!userRepository.existsByUsername("employee")) {
            User user = new User("employee", passwordEncoder.encode("employee"), "emplo", "yee");
            user.addRole(employeeRole);
            userRepository.save(user);
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
