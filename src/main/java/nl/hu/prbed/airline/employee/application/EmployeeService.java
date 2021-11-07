package nl.hu.prbed.airline.employee.application;

import nl.hu.prbed.airline.employee.application.exception.EmployeeNotFoundException;
import nl.hu.prbed.airline.employee.data.EmployeeRepository;
import nl.hu.prbed.airline.employee.domain.Employee;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeRequestDTO;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeResponseDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
        Employee employee = new Employee(employeeRequestDTO.firstName, employeeRequestDTO.lastName, employeeRequestDTO.dateOfBirth);
        System.out.println(employee.toString());
        this.employeeRepository.save(employee);
        System.out.println(employee.toString());
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
