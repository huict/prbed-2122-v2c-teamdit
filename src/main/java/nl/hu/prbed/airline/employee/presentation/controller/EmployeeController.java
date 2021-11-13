package nl.hu.prbed.airline.employee.presentation.controller;

import nl.hu.prbed.airline.employee.application.EmployeeService;
import nl.hu.prbed.airline.employee.application.EmployeeServiceImpl;
import nl.hu.prbed.airline.employee.application.exception.EmployeeAlreadyExistsException;
import nl.hu.prbed.airline.employee.application.exception.EmployeeNotFoundException;
import nl.hu.prbed.airline.employee.domain.Employee;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeRequestDTO;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeResponseDTO;
import nl.hu.prbed.airline.employee.presentation.exception.EmployeeAlreadyExistsHTTPException;
import nl.hu.prbed.airline.employee.presentation.exception.EmployeeNotFoundHTTPException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
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
        try {
            return new EmployeeResponseDTO(this.employeeService.findEmployeeById(id));
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundHTTPException(id);
        }
    }

    // Add Employee
    @PostMapping
    public EmployeeResponseDTO addEmployee(@Validated @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        try {
            Employee employee = this.employeeService.createEmployee(employeeRequestDTO);
            return new EmployeeResponseDTO(employee);
        } catch (EmployeeAlreadyExistsException e) {
            throw new EmployeeAlreadyExistsHTTPException(employeeRequestDTO.id);
        }
    }

    // Update Employee
    @PutMapping
    public EmployeeResponseDTO updateEmployee(@Validated @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        try {
            Employee employee = this.employeeService.updateEmployee(employeeRequestDTO);
            return new EmployeeResponseDTO(employee);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundHTTPException(employeeRequestDTO.id);
        }
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        try {
            this.employeeService.deleteEmployee(id);
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundHTTPException(id);
        }
    }

}
