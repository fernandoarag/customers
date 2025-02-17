package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerNotFoundException;
import br.com.fiap.postech.customermanagement.application.exception.custom.InvalidInputException;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.interfaces.gateway.database.CustomerGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DeleteCustomerUseCaseImplTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private DeleteCustomerUseCaseImpl deleteCustomerUseCaseImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteCustomerByIdSuccessfully() {
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setId(customerId);
        when(customerGateway.findById(customerId)).thenReturn(Optional.of(customer));

        deleteCustomerUseCaseImpl.deleteCustomerById(customerId);

        verify(customerGateway).deleteById(customerId);
    }

    @Test
    void deleteCustomerByIdThrowsInvalidInputExceptionWhenIdIsNull() {
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            deleteCustomerUseCaseImpl.deleteCustomerById(null);
        });

        assertEquals("ID cannot be null", exception.getMessage());
    }

    @Test
    void deleteCustomerByIdThrowsCustomerNotFoundExceptionWhenCustomerDoesNotExist() {
        Long customerId = 1L;
        when(customerGateway.findById(customerId)).thenReturn(Optional.empty());

        CustomerNotFoundException exception = assertThrows(CustomerNotFoundException.class, () -> {
            deleteCustomerUseCaseImpl.deleteCustomerById(customerId);
        });

        assertEquals("Customer with id: '1' not found!", exception.getMessage());
    }

    @Test
    void deleteCustomerByEmailSuccessfully() {
        String email = "test@example.com";
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail(email);
        when(customerGateway.findCustomerEntityByEmail(email)).thenReturn(Optional.of(customer));

        deleteCustomerUseCaseImpl.deleteCustomerByEmail(email);

        verify(customerGateway).deleteById(customer.getId());
    }

    @Test
    void deleteCustomerByEmailThrowsCustomerNotFoundExceptionWhenCustomerDoesNotExist() {
        String email = "test@example.com";
        when(customerGateway.findCustomerEntityByEmail(email)).thenReturn(Optional.empty());

        CustomerNotFoundException exception = assertThrows(CustomerNotFoundException.class, () -> {
            deleteCustomerUseCaseImpl.deleteCustomerByEmail(email);
        });

        assertEquals("Customer with email: 'test@example.com' not found!", exception.getMessage());
    }
}