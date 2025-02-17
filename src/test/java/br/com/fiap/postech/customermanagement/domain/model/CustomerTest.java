package br.com.fiap.postech.customermanagement.domain.model;

import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerNotFoundException;
import br.com.fiap.postech.customermanagement.application.usecases.customer.UpdateCustomerUseCaseImpl;
import br.com.fiap.postech.customermanagement.interfaces.gateway.database.CustomerGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CustomerTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private UpdateCustomerUseCaseImpl updateCustomerUseCaseImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /* Name */
    @Test
    void setNameUpdatesName() {
        Customer customer = new Customer();
        customer.setName("New Name");
        assertEquals("New Name", customer.getName());
    }

    @Test
    void setNameUpdatesNameToNull() {
        Customer customer = new Customer();
        customer.setName(null);
        assertNull(customer.getName());
    }

    @Test
    void setNameUpdatesNameToEmptyString() {
        Customer customer = new Customer();
        customer.setName("");
        assertEquals("", customer.getName());
    }

    /* Phone */
    @Test
    void setPhoneUpdatesPhone() {
        Customer customer = new Customer();
        customer.setPhone("New Phone");
        assertEquals("New Phone", customer.getPhone());
    }

    @Test
    void setPhoneUpdatesPhoneToNull() {
        Customer customer = new Customer();
        customer.setPhone(null);
        assertNull(customer.getPhone());
    }

    @Test
    void setPhoneUpdatesPhoneToEmptyString() {
        Customer customer = new Customer();
        customer.setPhone("");
        assertEquals("", customer.getPhone());
    }

    /* CellPhone */
    @Test
    void setCellPhoneUpdatesCellPhone() {
        Customer customer = new Customer();
        customer.setCellPhone("New Cell Phone");
        assertEquals("New Cell Phone", customer.getCellPhone());
    }

    @Test
    void setCellPhoneUpdatesCellPhoneToNull() {
        Customer customer = new Customer();
        customer.setCellPhone(null);
        assertNull(customer.getCellPhone());
    }

    @Test
    void setCellPhoneUpdatesCellPhoneToEmptyString() {
        Customer customer = new Customer();
        customer.setCellPhone("");
        assertEquals("", customer.getCellPhone());
    }

    /* ZipCode */
    @Test
    void setZipCodeUpdatesZipCode() {
        final String newValue = "New Zip Code";
        Customer customer = new Customer();
        customer.setZipCode(newValue);
        assertEquals(newValue, customer.getZipCode());
    }

    @Test
    void setZipCodeUpdatesZipCodeToNull() {
        Customer customer = new Customer();
        customer.setZipCode(null);
        assertNull(customer.getZipCode());
    }

    @Test
    void setZipCodeUpdatesZipCodeToEmptyString() {
        Customer customer = new Customer();
        customer.setZipCode("");
        assertEquals("", customer.getZipCode());
    }

    /* Address */
    @Test
    void setAddressUpdatesAddress() {
        final String newValue = "New Address";
        Customer customer = new Customer();
        customer.setAddress(newValue);
        assertEquals(newValue, customer.getAddress());
    }

    @Test
    void setAddressUpdatesAddressToNull() {
        Customer customer = new Customer();
        customer.setAddress(null);
        assertNull(customer.getAddress());
    }

    @Test
    void setAddressUpdatesAddressToEmptyString() {
        Customer customer = new Customer();
        customer.setAddress("");
        assertEquals("", customer.getAddress());
    }

    /* Address */
    @Test
    void setAddressNumberUpdatesAddressNumber() {
        final String newValue = "New Address Number";
        Customer customer = new Customer();
        customer.setAddressNumber(newValue);
        assertEquals(newValue, customer.getAddressNumber());
    }

    @Test
    void setAddressNumberUpdatesAddressNumberToNull() {
        Customer customer = new Customer();
        customer.setAddressNumber(null);
        assertNull(customer.getAddressNumber());
    }

    @Test
    void setAddressNumberUpdatesAddressNumberToEmptyString() {
        Customer customer = new Customer();
        customer.setAddressNumber("");
        assertEquals("", customer.getAddressNumber());
    }

    /* Neighborhood */
    @Test
    void setNeighborhoodUpdatesNeighborhood() {
        final String newValue = "New Neighborhood";
        Customer customer = new Customer();
        customer.setNeighborhood(newValue);
        assertEquals(newValue, customer.getNeighborhood());
    }

    @Test
    void setNeighborhoodUpdatesNeighborhoodToNull() {
        Customer customer = new Customer();
        customer.setNeighborhood(null);
        assertNull(customer.getNeighborhood());
    }

    @Test
    void setNeighborhoodUpdatesNeighborhoodToEmptyString() {
        Customer customer = new Customer();
        customer.setNeighborhood("");
        assertEquals("", customer.getNeighborhood());
    }

    /* City */
    @Test
    void setCityUpdatesCity() {
        final String newValue = "New City";
        Customer customer = new Customer();
        customer.setCity(newValue);
        assertEquals(newValue, customer.getCity());
    }

    @Test
    void setCityUpdatesCityToNull() {
        Customer customer = new Customer();
        customer.setCity(null);
        assertNull(customer.getCity());
    }

    @Test
    void setCityUpdatesCityToEmptyString() {
        Customer customer = new Customer();
        customer.setCity("");
        assertEquals("", customer.getCity());
    }

    /* State */
    @Test
    void setStateUpdatesState() {
        final String newValue = "New State";
        Customer customer = new Customer();
        customer.setState(newValue);
        assertEquals(newValue, customer.getState());
    }

    @Test
    void setStateUpdatesStateToNull() {
        Customer customer = new Customer();
        customer.setState(null);
        assertNull(customer.getState());
    }

    @Test
    void setStateUpdatesStateToEmptyString() {
        Customer customer = new Customer();
        customer.setState("");
        assertEquals("", customer.getState());
    }

    /* Complement */
    @Test
    void setComplementUpdatesComplement() {
        final String newValue = "New Complement";
        Customer customer = new Customer();
        customer.setComplement(newValue);
        assertEquals(newValue, customer.getComplement());
    }

    @Test
    void setComplementUpdatesComplementToNull() {
        Customer customer = new Customer();
        customer.setComplement(null);
        assertNull(customer.getComplement());
    }

    @Test
    void setComplementUpdatesComplementToEmptyString() {
        Customer customer = new Customer();
        customer.setComplement("");
        assertEquals("", customer.getComplement());
    }

    @Test
    void updateCustomerByIdUpdatesAllFields() {
        Long customerId = 1L;
        Customer existingCustomer = new Customer(customerId, "Old Name", "old.email@example.com", "111111111", "222222222", "00000", "Old St", "1", "Old Neighborhood", "Old City", "Old State", "Old Complement");
        Customer customerUpdate = new Customer("New Name", "old.email@example.com", "333333333", "444444444", "12345", "New St", "100", "New Neighborhood", "New City", "New State", "New Complement");
        when(customerGateway.findById(customerId)).thenReturn(Optional.of(existingCustomer));
        when(customerGateway.save(existingCustomer)).thenReturn(existingCustomer);

        Customer updatedCustomer = updateCustomerUseCaseImpl.updateCustomerById(customerId, customerUpdate);

        verify(customerGateway).save(existingCustomer);
        assertEquals("New Name", updatedCustomer.getName());
        assertEquals("old.email@example.com", updatedCustomer.getEmail());
        assertEquals("333333333", updatedCustomer.getPhone());
        assertEquals("444444444", updatedCustomer.getCellPhone());
        assertEquals("12345", updatedCustomer.getZipCode());
        assertEquals("New St", updatedCustomer.getAddress());
        assertEquals("100", updatedCustomer.getAddressNumber());
        assertEquals("New Neighborhood", updatedCustomer.getNeighborhood());
        assertEquals("New City", updatedCustomer.getCity());
        assertEquals("New State", updatedCustomer.getState());
        assertEquals("New Complement", updatedCustomer.getComplement());
    }

    @Test
    void updateCustomerByIdDoesNotUpdateId() {
        Long customerId = 1L;
        Customer existingCustomer = new Customer(customerId, "Old Name", "old.email@example.com", "111111111", "222222222", "00000", "Old St", "1", "Old Neighborhood", "Old City", "Old State", "Old Complement");
        Customer customerUpdate = new Customer(2L, "New Name", "new.email@example.com", "333333333", "444444444", "12345", "New St", "100", "New Neighborhood", "New City", "New State", "New Complement");
        when(customerGateway.findById(customerId)).thenReturn(Optional.of(existingCustomer));
        when(customerGateway.save(existingCustomer)).thenReturn(existingCustomer);

        Customer updatedCustomer = updateCustomerUseCaseImpl.updateCustomerById(customerId, customerUpdate);

        verify(customerGateway).save(existingCustomer);
        assertEquals(customerId, updatedCustomer.getId());
    }


    @Test
    void updatingClientByIdThrowsInvalidInputExceptionWhenCustomerIsNotFound() {
        Long customerId = 1L;

        CustomerNotFoundException exception = assertThrows(CustomerNotFoundException.class, () -> {
            updateCustomerUseCaseImpl.updateCustomerById(customerId, null);
        });

        assertEquals("Customer with id: '1' not found!", exception.getMessage());
    }

    @Test
    void updateCustomerByIdThrowsInvalidInputExceptionWhenCustomerIdIsNegative() {
        Long customerId = -1L;
        Customer customerUpdate = new Customer("New Name", "new.email@example.com", "333333333", "444444444", "12345", "New St", "100", "New Neighborhood", "New City", "New State", "New Complement");

        CustomerNotFoundException exception = assertThrows(CustomerNotFoundException.class, () -> {
            updateCustomerUseCaseImpl.updateCustomerById(customerId, customerUpdate);
        });

        assertEquals("Customer with id: '-1' not found!", exception.getMessage());
    }
}