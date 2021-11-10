package nl.hu.prbed.airline.employee.application;

import nl.hu.prbed.airline.employee.application.exception.EmployeeNotFoundException;
import nl.hu.prbed.airline.employee.data.EmployeeRepository;
import nl.hu.prbed.airline.employee.domain.Employee;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeRequestDTO;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeResponseDTO;
import nl.hu.prbed.airline.security.application.UserService;
import nl.hu.prbed.airline.security.domain.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserService userService;

    public EmployeeService(EmployeeRepository employeeRepository, UserService userService) {
        this.employeeRepository = employeeRepository;
        this.userService = userService;
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDTOS.add(new EmployeeResponseDTO(employee));
        }
        return employeeDTOS;
    }

    public Employee findEmployeeById(Long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        User user = userService.createUser(employeeRequestDTO);
        Employee employee = new Employee(user.getId(), employeeRequestDTO.firstName, employeeRequestDTO.lastName, employeeRequestDTO.dateOfBirth);
        this.employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee updatedEmployee = new Employee(employeeRequestDTO.id, employeeRequestDTO.firstName, employeeRequestDTO.lastName, employeeRequestDTO.dateOfBirth);

        employeeRepository.findById(updatedEmployee.getId())
                .orElseThrow(() -> new EmployeeNotFoundException(updatedEmployee.getId()));

        employeeRepository.saveAndFlush(updatedEmployee);
        return updatedEmployee;
    }

    public void deleteEmployee(Long id) {
        this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        this.employeeRepository.deleteById(id);
    }
}
