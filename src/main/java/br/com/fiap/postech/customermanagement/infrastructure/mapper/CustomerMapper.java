package br.com.fiap.postech.customermanagement.infrastructure.mapper;

import br.com.fiap.postech.customermanagement.domain.factory.CustomerFactory;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.infrastructure.entity.CustomerEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between Customer domain model and CustomerEntity.
 */
@Component
public class CustomerMapper {

    private final CustomerFactory customerFactory;

    /**
     * Constructor for CustomerMapper.
     *
     * @param customerFactory the factory to create Customer instances
     */
    public CustomerMapper(CustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
    }

    /**
     * Converts a CustomerEntity to a Customer domain model.
     *
     * @param entity the CustomerEntity to convert
     * @return the corresponding Customer domain model, or null if the entity is null
     */
    public Customer toDomain(CustomerEntity entity) {
        if (entity == null) return null;
        return customerFactory.create(
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

    /**
     * Converts a Customer domain model to a CustomerEntity.
     *
     * @param customer the Customer domain model to convert
     * @return the corresponding CustomerEntity, or null if the customer is null
     */
    public CustomerEntity toEntity(Customer customer) {
        if (customer == null) return null;
        return new CustomerEntity(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getCellPhone(),
                customer.getZipCode(),
                customer.getAddress(),
                customer.getAddressNumber(),
                customer.getNeighborhood(),
                customer.getCity(),
                customer.getState(),
                customer.getComplement()
        );
    }
}