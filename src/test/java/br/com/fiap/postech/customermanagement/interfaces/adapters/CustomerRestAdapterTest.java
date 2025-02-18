package br.com.fiap.postech.customermanagement.interfaces.adapters;

import br.com.fiap.postech.customermanagement.domain.model.Address;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerRequestDTO;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerResponseDTO;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerUpdateRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNull;

class CustomerRestAdapterTest {

    private CustomerRestAdapter customerRestAdapter;

    @BeforeEach
    void setUp() {
        customerRestAdapter = new CustomerRestAdapter();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void toDomainConvertsCustomerRequestDTOWithNullValuesToCustomer() {
        CustomerRequestDTO dto = new CustomerRequestDTO(null, null, null, null, null, null, null, null, null, null, null);
        Customer result = customerRestAdapter.toDomain(dto);

        assertNull(result.getName());
        assertNull(result.getEmail());
        assertNull(result.getPhone());
        assertNull(result.getCellPhone());
        assertNull(result.getAddress().getZipCode());
        assertNull(result.getAddress().getName());
        assertNull(result.getAddress().getAddressNumber());
        assertNull(result.getAddress().getNeighborhood());
        assertNull(result.getAddress().getCity());
        assertNull(result.getAddress().getState());
        assertNull(result.getAddress().getComplement());
    }

    @Test
    void toDomainConvertsCustomerUpdateRequestDTOWithNullValuesToCustomer() {
        CustomerUpdateRequestDTO dto = new CustomerUpdateRequestDTO(null, null, null, null, null, null, null, null, null, null);
        Customer result = customerRestAdapter.toDomain(dto);

        assertNull(result.getName());
        assertNull(result.getPhone());
        assertNull(result.getCellPhone());
        assertNull(result.getAddress().getZipCode());
        assertNull(result.getAddress().getName());
        assertNull(result.getAddress().getAddressNumber());
        assertNull(result.getAddress().getNeighborhood());
        assertNull(result.getAddress().getCity());
        assertNull(result.getAddress().getState());
        assertNull(result.getAddress().getComplement());
    }

    @Test
    void toResponseConvertsCustomerWithNullValuesToCustomerResponseDTO() {
        Address address = new Address(null, null, null, null, null, null, null);
        Customer customer = new Customer(null, null, null, null, null, address);
        CustomerResponseDTO result = customerRestAdapter.toResponse(customer);

        assertNull(result.id());
        assertNull(result.name());
        assertNull(result.email());
        assertNull(result.phone());
        assertNull(result.cellPhone());
        assertNull(result.zipCode());
        assertNull(result.address());
        assertNull(result.addressNumber());
        assertNull(result.neighborhood());
        assertNull(result.city());
        assertNull(result.state());
        assertNull(result.complement());
    }
}