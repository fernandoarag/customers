package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerAlreadyExistsException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailCannotBeBlankException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailInvalidException;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.interfaces.gateway.database.CustomerGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CreateCustomerUseCaseImplTest {

    private CustomerGateway customerGateway;
    private CreateCustomerUseCaseImpl createCustomerUseCase;

    @BeforeEach
    void setUp() {
        customerGateway = mock(CustomerGateway.class);
        createCustomerUseCase = new CreateCustomerUseCaseImpl(customerGateway);
    }

    @Test
    void shouldCreateCustomerSuccessfully() {
        Customer customer = new Customer("John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "City", "State", "Apt 1");
        when(customerGateway.save(customer)).thenReturn(customer);

        Customer result = createCustomerUseCase.execute(customer);

        assertEquals(customer, result);
        verify(customerGateway, times(1)).save(customer);
    }

    @Test
    void shouldThrowExceptionWhenEmailIsBlank() {
        Customer customer = new Customer("John Doe", "", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "City", "State", "Apt 1");

        assertThrows(CustomerEmailCannotBeBlankException.class, () -> createCustomerUseCase.execute(customer));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {
        Customer customer = new Customer("John Doe", "invalid-email", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "City", "State", "Apt 1");

        assertThrows(CustomerEmailInvalidException.class, () -> createCustomerUseCase.execute(customer));
    }

    @Test
    void shouldThrowExceptionWhenCustomerAlreadyExists() {
        Customer customer = new Customer("John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "City", "State", "Apt 1");
        when(customerGateway.findCustomerEntityByEmail(customer.getEmail())).thenReturn(Optional.of(customer));

        assertThrows(CustomerAlreadyExistsException.class, () -> createCustomerUseCase.execute(customer));
    }

    @Test
    void shouldHandleNullCustomer() {
        assertThrows(NullPointerException.class, () -> createCustomerUseCase.execute(null));
    }
}