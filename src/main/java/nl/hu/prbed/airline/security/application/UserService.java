package nl.hu.prbed.airline.security.application;

import nl.hu.prbed.airline.customer.application.CustomerServiceImpl;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerDTO;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerRequestDTO;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeRequestDTO;
import nl.hu.prbed.airline.security.application.exception.UsernameAlreadyExists;
import nl.hu.prbed.airline.security.data.RoleRepository;
import nl.hu.prbed.airline.security.data.UserRepository;
import nl.hu.prbed.airline.security.domain.Role;
import nl.hu.prbed.airline.security.domain.User;
import nl.hu.prbed.airline.security.presentation.dto.Registration;
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
    private final CustomerServiceImpl customerService;

    public UserService(UserRepository repository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, CustomerServiceImpl customerService) {
        this.userRepository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.customerService = customerService;
    }

    public void register(Registration registration) {
        if (this.userRepository.existsByUsername(registration.username)) {
            throw new UsernameAlreadyExists(registration.username);
        }

        String encodedUserPassword = this.passwordEncoder.encode(registration.password);
        User user = new User(registration.username, encodedUserPassword, registration.firstName, registration.lastName);

        Role userRole = roleRepository.findByName("ROLE_USER");
        user.addRole(userRole);

        this.userRepository.save(user);

        CustomerDTO customerDTO = new CustomerDTO(user.getId(),
                registration.firstName,
                registration.lastName,
                registration.dateOfBirth,
                registration.phoneNumber,
                registration.emailAddress,
                registration.nationality);

        customerService.createCustomer(customerDTO);
    }

    @Override
    public User loadUserByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public User getUser(CustomerRequestDTO customerRequestDTO) {
        return createUser(customerRequestDTO.username, customerRequestDTO.password, customerRequestDTO.firstName, customerRequestDTO.lastName);
    }

    public User getUser(EmployeeRequestDTO employeeRequestDTO) {
        return createUser(employeeRequestDTO.username, employeeRequestDTO.password, employeeRequestDTO.firstName, employeeRequestDTO.lastName);
    }

    private User createUser(String username, String password, String firstName, String lastName) {
        String encodedUserPassword = this.passwordEncoder.encode(password);
        User user = new User(username,
                encodedUserPassword,
                firstName,
                lastName);

        if (userRepository.existsByUsername(username)) {
            throw new UsernameAlreadyExists(username);
        }
        userRepository.save(user);

        return user;
    }
}
