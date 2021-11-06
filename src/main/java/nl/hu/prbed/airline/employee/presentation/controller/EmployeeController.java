package nl.hu.prbed.airline.employee.presentation.controller;

import nl.hu.prbed.airline.airport.application.AirportService;
import nl.hu.prbed.airline.airport.domain.Airport;
import nl.hu.prbed.airline.airport.presentation.dto.AirportDTO;
import nl.hu.prbed.airline.airport.presentation.dto.AirportRequestDTO;
import nl.hu.prbed.airline.airport.presentation.dto.AirportResponseDTO;
import nl.hu.prbed.airline.employee.application.EmployeeService;
import nl.hu.prbed.airline.employee.domain.Employee;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeRequestDTO;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeResponseDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //get All employeets
    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    //get Employee by id
    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
        return new EmployeeResponseDTO(this.employeeService.findEmployeeById(id));
    }

    // Add Employee
    @PostMapping
    public EmployeeResponseDTO addEmployee(@Validated @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = this.employeeService.createEmployee(employeeRequestDTO);
        return new EmployeeResponseDTO(employee);
    }

    // Update Employee
    @PutMapping
    public EmployeeResponseDTO updateEmployee(@Validated @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = this.employeeService.updateEmployee(employeeRequestDTO);
        return new EmployeeResponseDTO(employee);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        this.employeeService.deleteEmployee(id);
    }

}
