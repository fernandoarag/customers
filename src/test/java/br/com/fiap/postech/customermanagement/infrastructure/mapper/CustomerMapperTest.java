
package br.com.fiap.postech.customermanagement.infrastructure.mapper;

import br.com.fiap.postech.customermanagement.domain.factory.CustomerFactory;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.infrastructure.entity.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CustomerMapperTest {

    private CustomerFactory customerFactory;
    private CustomerMapper customerMapper;

    @BeforeEach
    void setUp() {
        customerFactory = Mockito.mock(CustomerFactory.class);
        customerMapper = new CustomerMapper(customerFactory);
    }

    @Test
    void toDomainReturnsNullWhenEntityIsNull() {
        assertNull(customerMapper.toDomain(null));
    }

    @Test
    void toDomainReturnsCustomerWithCorrectValues() {
        CustomerEntity entity = new CustomerEntity(1L, "John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1");
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1");
        Mockito.when(customerFactory.create(1L, "John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1")).thenReturn(customer);

        Customer result = customerMapper.toDomain(entity);

        assertEquals(customer, result);
    }

    @Test
    void toEntityReturnsNullWhenCustomerIsNull() {
        assertNull(customerMapper.toEntity(null));
    }

    @Test
    void toEntityReturnsCustomerEntityWithCorrectValues() {
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com", "123456789", "987654321", "12345", "Main St", "100", "Downtown", "Metropolis", "NY", "Apt 1");
        CustomerEntity result = customerMapper.toEntity(customer);

        assertEquals(1L, result.getId());
        assertEquals("John Doe", result.getName());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals("123456789", result.getPhone());
        assertEquals("987654321", result.getCellPhone());
        assertEquals("12345", result.getZipCode());
        assertEquals("Main St", result.getAddress());
        assertEquals("100", result.getAddressNumber());
        assertEquals("Downtown", result.getNeighborhood());
        assertEquals("Metropolis", result.getCity());
        assertEquals("NY", result.getState());
        assertEquals("Apt 1", result.getComplement());
    }

    @Test
    void toDomainReturnsCustomerWithNullValues() {
        CustomerEntity entity = new CustomerEntity(null, null, null, null, null, null, null, null, null, null, null, null);
        Customer customer = new Customer(null, null, null, null, null, null, null, null, null, null, null, null);
        Mockito.when(customerFactory.create(null, null, null, null, null, null, null, null, null, null, null, null)).thenReturn(customer);

        Customer result = customerMapper.toDomain(entity);

        assertEquals(customer, result);
    }

    @Test
    void toEntityReturnsCustomerEntityWithNullValues() {
        Customer customer = new Customer(null, null, null, null, null, null, null, null, null, null, null, null);
        CustomerEntity result = customerMapper.toEntity(customer);

        assertNull(result.getId());
        assertNull(result.getName());
        assertNull(result.getEmail());
        assertNull(result.getPhone());
        assertNull(result.getCellPhone());
        assertNull(result.getZipCode());
        assertNull(result.getAddress());
        assertNull(result.getAddressNumber());
        assertNull(result.getNeighborhood());
        assertNull(result.getCity());
        assertNull(result.getState());
        assertNull(result.getComplement());
    }

    @Test
    void toDomainHandlesPartialValues() {
        CustomerEntity entity = new CustomerEntity(1L, "John Doe", null, "123456789", null, "12345", null, "100", null, "Metropolis", null, "Apt 1");
        Customer customer = new Customer(1L, "John Doe", null, "123456789", null, "12345", null, "100", null, "Metropolis", null, "Apt 1");
        Mockito.when(customerFactory.create(1L, "John Doe", null, "123456789", null, "12345", null, "100", null, "Metropolis", null, "Apt 1")).thenReturn(customer);

        Customer result = customerMapper.toDomain(entity);

        assertEquals(customer, result);
    }

    @Test
    void toEntityHandlesPartialValues() {
        Customer customer = new Customer(1L, "John Doe", null, "123456789", null, "12345", null, "100", null, "Metropolis", null, "Apt 1");
        CustomerEntity result = customerMapper.toEntity(customer);

        assertEquals(1L, result.getId());
        assertEquals("John Doe", result.getName());
        assertNull(result.getEmail());
        assertEquals("123456789", result.getPhone());
        assertNull(result.getCellPhone());
        assertEquals("12345", result.getZipCode());
        assertNull(result.getAddress());
        assertEquals("100", result.getAddressNumber());
        assertNull(result.getNeighborhood());
        assertEquals("Metropolis", result.getCity());
        assertNull(result.getState());
        assertEquals("Apt 1", result.getComplement());
    }
}