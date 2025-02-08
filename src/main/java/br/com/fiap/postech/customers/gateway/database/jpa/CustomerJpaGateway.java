package br.com.fiap.postech.customers.gateway.database.jpa;

import br.com.fiap.postech.customers.domain.Customers;
import br.com.fiap.postech.customers.exception.CustomerAlreadyExistsException;
import br.com.fiap.postech.customers.exception.CustomerNotFoundException;
import br.com.fiap.postech.customers.gateway.CustomerGateway;
import br.com.fiap.postech.customers.gateway.database.jpa.entity.CustomerEntity;
import br.com.fiap.postech.customers.gateway.database.jpa.repository.CustomerRepository;
import br.com.fiap.postech.customers.gateway.database.jpa.repository.filter.domain.CustomersFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerJpaGateway implements CustomerGateway {

    private final CustomerRepository customerRepository;

    public CustomerJpaGateway(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customers save(final Customers customers) {
        this.validCustomerAlreadyExistsEmail(customers.getEmail());
        CustomerEntity entity = toEntity(customers);
        return this.toDomain(customerRepository.save(entity));
    }

    public List<Customers> filter(CustomersFilter customersFilter) {
        return customerRepository.filter(customersFilter).stream().map(this::toDomain).collect(Collectors.toList());
    }

    public Optional<Customers> findById(final Long id) {
        return customerRepository.findById(id).map(this::toDomain);
    }

    public Optional<Customers> findCustomerEntityByEmail(final String email) {
        return customerRepository.findCustomerEntityByEmail(email).map(this::toDomain);
    }

    public void validCustomerAlreadyExistsEmail(String email) {
        if (customerRepository.findCustomerEntityByEmail(email).isPresent()) {
            throw new CustomerAlreadyExistsException(email);
        }
    }

    public void deleteById(final Long id) {
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("id", id.toString()));
        customerRepository.deleteById(id);
    }

    private CustomerEntity toEntity(Customers customers) {
        CustomerEntity entity = new CustomerEntity();
        BeanUtils.copyProperties(customers, entity);
        return entity;
    }

    private Customers toDomain(CustomerEntity entity) {
        return new Customers(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getCellPhone(),
                entity.getZipCode(),
                entity.getAddress(),
                entity.getAddressNumber(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getComplement()
        );
    }
}
