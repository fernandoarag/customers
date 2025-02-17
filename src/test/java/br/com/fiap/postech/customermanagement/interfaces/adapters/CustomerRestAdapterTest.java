package br.com.fiap.postech.customermanagement.interfaces.adapters;

import br.com.fiap.postech.customermanagement.domain.factory.CustomerFactory;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerRequestDTO;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerResponseDTO;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerUpdateRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CustomerRestAdapterTest {

    @Mock
    private CustomerFactory customerFactory;

    private CustomerRestAdapter customerRestAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerRestAdapter = new CustomerRestAdapter(customerFactory);
    }

    @Test
    void toDomainConvertsCustomerRequestDTOToCustomer() {
        CustomerRequestDTO dto = new CustomerRequestDTO("John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1");
        Customer customer = new Customer("John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1");

        when(customerFactory.create(
                dto.name(), dto.email(), dto.phone(), dto.cellPhone(), dto.zipCode(), dto.address(), dto.addressNumber(), dto.neighborhood(), dto.city(), dto.state(), dto.complement()
        )).thenReturn(customer);

        Customer result = customerRestAdapter.toDomain(dto);

        assertEquals(customer, result);
    }

    @Test
    void toDomainConvertsCustomerUpdateRequestDTOToCustomer() {
        CustomerUpdateRequestDTO dto = new CustomerUpdateRequestDTO("John Doe", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1");
        Customer customer = new Customer("John Doe", null, "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1");

        when(customerFactory.create(
                dto.name(), null, dto.phone(), dto.cellPhone(), dto.zipCode(), dto.address(), dto.addressNumber(), dto.neighborhood(), dto.city(), dto.state(), dto.complement()
        )).thenReturn(customer);

        Customer result = customerRestAdapter.toDomain(dto);

        assertEquals(customer, result);
    }

    @Test
    void toResponseConvertsCustomerToCustomerResponseDTO() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1");
        CustomerResponseDTO responseDTO = new CustomerResponseDTO(1L, "John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1");

        CustomerResponseDTO result = customerRestAdapter.toResponse(customer);

        assertEquals(responseDTO, result);
    }
}