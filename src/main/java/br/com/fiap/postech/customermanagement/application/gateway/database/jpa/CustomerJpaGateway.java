package br.com.fiap.postech.customermanagement.application.gateway.database.jpa;

import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerAlreadyExistsException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerNotFoundException;
import br.com.fiap.postech.customermanagement.application.gateway.CustomerGateway;
import br.com.fiap.postech.customermanagement.application.gateway.database.jpa.entity.CustomerEntity;
import br.com.fiap.postech.customermanagement.application.gateway.database.jpa.repository.CustomerRepository;
import br.com.fiap.postech.customermanagement.application.gateway.database.jpa.repository.filter.CustomerFilter;
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
    public Customer save(final Customer customer) {
        this.validCustomerAlreadyExistsEmail(customer.getEmail());
        CustomerEntity entity = toEntity(customer);
        return this.toDomain(customerRepository.save(entity));
    }

    public List<Customer> filter(CustomerFilter customerFilter) {
        return customerRepository.filter(customerFilter).stream().map(this::toDomain).collect(Collectors.toList());
    }

    public Optional<Customer> findById(final Long id) {
        return customerRepository.findById(id).map(this::toDomain);
    }

    public Optional<Customer> findCustomerEntityByEmail(final String email) {
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

    private CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .cellPhone(customer.getCellPhone())
                .zipCode(customer.getZipCode())
                .address(customer.getAddress())
                .addressNumber(customer.getAddressNumber())
                .neighborhood(customer.getNeighborhood())
                .city(customer.getCity())
                .state(customer.getState())
                .complement(customer.getComplement())
                .build();
    }

    private Customer toDomain(CustomerEntity entity) {
        return new Customer(
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
