package br.com.fiap.postech.customermanagement.application.factory;

import br.com.fiap.postech.customermanagement.domain.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryImplTest {
    @Test
    void shouldCreateCustomerWithId() {
        CustomerFactoryImpl factory = new CustomerFactoryImpl();
        Customer customer = factory.create(1L, "John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "City", "State", "Apt 1");
        assertEquals(1L, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals("123456789", customer.getPhone());
        assertEquals("987654321", customer.getCellPhone());
        assertEquals("12345", customer.getZipCode());
        assertEquals("Main St", customer.getAddress());
        assertEquals("100", customer.getAddressNumber());
        assertEquals("Downtown", customer.getNeighborhood());
        assertEquals("City", customer.getCity());
        assertEquals("State", customer.getState());
        assertEquals("Apt 1", customer.getComplement());
    }

    @Test
    void shouldCreateCustomerWithoutId() {
        CustomerFactoryImpl factory = new CustomerFactoryImpl();
        Customer customer = factory.create("John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "City", "State", "Apt 1");
        assertNull(customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals("123456789", customer.getPhone());
        assertEquals("987654321", customer.getCellPhone());
        assertEquals("12345", customer.getZipCode());
        assertEquals("Main St", customer.getAddress());
        assertEquals("100", customer.getAddressNumber());
        assertEquals("Downtown", customer.getNeighborhood());
        assertEquals("City", customer.getCity());
        assertEquals("State", customer.getState());
        assertEquals("Apt 1", customer.getComplement());
    }

    @Test
    void shouldHandleNullValues() {
        CustomerFactoryImpl factory = new CustomerFactoryImpl();
        Customer customer = factory.create(null, null, null, null, null, null, null, null, null, null, null, null);
        assertNull(customer.getId());
        assertNull(customer.getName());
        assertNull(customer.getEmail());
        assertNull(customer.getPhone());
        assertNull(customer.getCellPhone());
        assertNull(customer.getZipCode());
        assertNull(customer.getAddress());
        assertNull(customer.getAddressNumber());
        assertNull(customer.getNeighborhood());
        assertNull(customer.getCity());
        assertNull(customer.getState());
        assertNull(customer.getComplement());
    }

    @Test
    void shouldHandleEmptyStrings() {
        CustomerFactoryImpl factory = new CustomerFactoryImpl();
        Customer customer = factory.create(null, "", "", "", "", "", "", "", "", "", "", "");
        assertNull(customer.getId());
        assertEquals("", customer.getName());
        assertEquals("", customer.getEmail());
        assertEquals("", customer.getPhone());
        assertEquals("", customer.getCellPhone());
        assertEquals("", customer.getZipCode());
        assertEquals("", customer.getAddress());
        assertEquals("", customer.getAddressNumber());
        assertEquals("", customer.getNeighborhood());
        assertEquals("", customer.getCity());
        assertEquals("", customer.getState());
        assertEquals("", customer.getComplement());
    }
}