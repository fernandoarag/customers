package br.com.fiap.postech.customermanagement.interfaces.gateway.impl;

import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerAlreadyExistsException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerNotFoundException;
import br.com.fiap.postech.customermanagement.infrastructure.entity.CustomerEntity;
import br.com.fiap.postech.customermanagement.infrastructure.mapper.CustomerMapper;
import br.com.fiap.postech.customermanagement.infrastructure.repository.CustomerRepository;
import br.com.fiap.postech.customermanagement.interfaces.gateway.database.CustomerGateway;
import br.com.fiap.postech.customermanagement.infrastructure.repository.filter.CustomerFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerJpaGateway implements CustomerGateway {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public Customer save(final Customer customer) {
        var entity = mapper.toEntity(customer);
        return mapper.toDomain(repository.save(entity));
    }

    public List<Customer> filter(CustomerFilter customerFilter) {
        return repository.filter(customerFilter).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    public Optional<Customer> findById(final Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public Optional<Customer> findCustomerEntityByEmail(final String email) {
        return repository.findCustomerEntityByEmail(email).map(mapper::toDomain);
    }

    public void deleteById(final Long customerID) {
        repository.findById(customerID).orElseThrow(() -> new CustomerNotFoundException("id", customerID.toString()));
        repository.deleteById(customerID);
    }

}
