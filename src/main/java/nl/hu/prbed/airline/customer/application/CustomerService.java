package nl.hu.prbed.airline.customer.application;

import nl.hu.prbed.airline.customer.domain.Customer;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerRequestDTO;
import nl.hu.prbed.airline.customer.presentation.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    Customer updateCustomer(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> getAllCustomers();
    void deleteCustomer(Long id);
    Customer findCustomerById(long id);
    Customer createCustomer(CustomerRequestDTO customerRequestDTO);
}
