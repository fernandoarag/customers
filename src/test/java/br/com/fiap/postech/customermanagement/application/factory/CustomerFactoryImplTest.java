package br.com.fiap.postech.customermanagement.application.factory;

import br.com.fiap.postech.customermanagement.domain.model.Address;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CustomerFactoryImplTest {
    @Test
    void shouldCreateCustomerWithId() {
        final Address address = new Address("12345", "Main St", "100", "Downtown", "City", "State", "Apt 1");
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "123456789", "987654321", address);
        assertEquals(1L, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals("123456789", customer.getPhone());
        assertEquals("987654321", customer.getCellPhone());
        assertEquals("12345", customer.getAddress().getZipCode());
        assertEquals("Main St", customer.getAddress().getName());
        assertEquals("100", customer.getAddress().getAddressNumber());
        assertEquals("Downtown", customer.getAddress().getNeighborhood());
        assertEquals("City", customer.getAddress().getCity());
        assertEquals("State", customer.getAddress().getState());
        assertEquals("Apt 1", customer.getAddress().getComplement());
    }

    @Test
    void shouldCreateCustomerWithoutId() {
        final Address address = new Address("12345", "Main St", "100", "Downtown", "City", "State", "Apt 1");
        Customer customer = new Customer("John Doe", "john.doe@example.com", "123456789", "987654321", address);
        assertNull(customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertEquals("123456789", customer.getPhone());
        assertEquals("987654321", customer.getCellPhone());
        assertEquals("12345", customer.getAddress().getZipCode());
        assertEquals("Main St", customer.getAddress().getName());
        assertEquals("100", customer.getAddress().getAddressNumber());
        assertEquals("Downtown", customer.getAddress().getNeighborhood());
        assertEquals("City", customer.getAddress().getCity());
        assertEquals("State", customer.getAddress().getState());
        assertEquals("Apt 1", customer.getAddress().getComplement());
    }

    @Test
    void shouldHandleNullValues() {
        final Address address = new Address(null, null, null, null, null, null, null);
        Customer customer = new Customer(null, null, null, null, null, address);
        assertNull(customer.getId());
        assertNull(customer.getName());
        assertNull(customer.getEmail());
        assertNull(customer.getPhone());
        assertNull(customer.getCellPhone());
        assertNull(customer.getAddress().getZipCode());
        assertNull(customer.getAddress().getName());
        assertNull(customer.getAddress().getAddressNumber());
        assertNull(customer.getAddress().getNeighborhood());
        assertNull(customer.getAddress().getCity());
        assertNull(customer.getAddress().getState());
        assertNull(customer.getAddress().getComplement());
    }

    @Test
    void shouldHandleEmptyStrings() {
        Customer customer = new Customer(null, "", "", "", "", new Address("", "", "", "", "", "", ""));
        assertNull(customer.getId());
        assertEquals("", customer.getName());
        assertEquals("", customer.getEmail());
        assertEquals("", customer.getPhone());
        assertEquals("", customer.getCellPhone());
        assertEquals("", customer.getAddress().getZipCode());
        assertEquals("", customer.getAddress().getName());
        assertEquals("", customer.getAddress().getAddressNumber());
        assertEquals("", customer.getAddress().getNeighborhood());
        assertEquals("", customer.getAddress().getCity());
        assertEquals("", customer.getAddress().getState());
        assertEquals("", customer.getAddress().getComplement());
    }
}