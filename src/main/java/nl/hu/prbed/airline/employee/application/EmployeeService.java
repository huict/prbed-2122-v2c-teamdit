package nl.hu.prbed.airline.employee.application;

import nl.hu.prbed.airline.employee.domain.Employee;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeRequestDTO;
import nl.hu.prbed.airline.employee.presentation.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> getAllEmployees();
    Employee findEmployeeById(Long id);
    Employee createEmployee(EmployeeRequestDTO employeeRequestDTO);
    Employee updateEmployee(EmployeeRequestDTO employeeRequestDTO);
    void deleteEmployee(Long id);
}
