package br.com.fiap.postech.customermanagement.infrastructure.mapper;

import br.com.fiap.postech.customermanagement.domain.model.Address;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.infrastructure.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toDomain(CustomerEntity entity) {
        if (entity == null) return null;
        final Address address = new Address(
                entity.getZipCode(),
                entity.getAddress(),
                entity.getAddressNumber(),
                entity.getNeighborhood(),
                entity.getCity(),
                entity.getState(),
                entity.getComplement()
        );
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getCellPhone(),
                address
        );
    }

    public CustomerEntity toEntity(Customer customer) {
        if (customer == null) return null;
        final Address address = customer.getAddress();
        return new CustomerEntity(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getCellPhone(),
                address.getZipCode(),
                address.getName(),
                address.getAddressNumber(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getComplement()
        );
    }
}