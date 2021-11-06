package nl.hu.prbed.airline.security.application;

import nl.hu.prbed.airline.security.application.exception.UsernameAlreadyExists;
import nl.hu.prbed.airline.security.data.RoleRepository;
import nl.hu.prbed.airline.security.data.UserRepository;
import nl.hu.prbed.airline.security.domain.Role;
import nl.hu.prbed.airline.security.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(String username, String password, String firstName, String lastName) {
        if (this.userRepository.existsByUsername(username)) {
            throw new UsernameAlreadyExists(username);
        }

        String encodedUserPassword = this.passwordEncoder.encode(password);
        User user = new User(username, encodedUserPassword, firstName, lastName);

        Role userRole = roleRepository.findByName("ROLE_USER");
        user.addRole(userRole);

        this.userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
