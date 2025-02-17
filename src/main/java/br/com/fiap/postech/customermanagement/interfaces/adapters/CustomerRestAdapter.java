package br.com.fiap.postech.customermanagement.interfaces.adapters;

import br.com.fiap.postech.customermanagement.domain.factory.CustomerFactory;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerRequestDTO;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerResponseDTO;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerUpdateRequestDTO;
import org.springframework.stereotype.Component;

/**
 * Adapter class for converting between Customer domain model and various DTOs.
 */
@Component
public class CustomerRestAdapter {

    private final CustomerFactory customerFactory;

    /**
     * Constructor for CustomerRestAdapter.
     *
     * @param customerFactory the factory to create Customer instances
     */
    public CustomerRestAdapter(CustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
    }

    /**
     * Converts a CustomerRequestDTO to a Customer domain model.
     *
     * @param dto the CustomerRequestDTO to convert
     * @return the corresponding Customer domain model
     */
    public Customer toDomain(CustomerRequestDTO dto) {
        return customerFactory.create(
                dto.name(),
                dto.email(),
                dto.phone(),
                dto.cellPhone(),
                dto.zipCode(),
                dto.address(),
                dto.addressNumber(),
                dto.neighborhood(),
                dto.city(),
                dto.state(),
                dto.complement()
        );
    }

    /**
     * Converts a CustomerUpdateRequestDTO to a Customer domain model.
     *
     * @param dto the CustomerUpdateRequestDTO to convert
     * @return the corresponding Customer domain model
     */
    public Customer toDomain(CustomerUpdateRequestDTO dto) {
        return customerFactory.create(
                dto.name(),
                null,
                dto.phone(),
                dto.cellPhone(),
                dto.zipCode(),
                dto.address(),
                dto.addressNumber(),
                dto.neighborhood(),
                dto.city(),
                dto.state(),
                dto.complement()
        );
    }

    /**
     * Converts a Customer domain model to a CustomerResponseDTO.
     *
     * @param saved the Customer domain model to convert
     * @return the corresponding CustomerResponseDTO
     */
    public CustomerResponseDTO toResponse(Customer saved) {
        return new CustomerResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getPhone(),
                saved.getCellPhone(),
                saved.getZipCode(),
                saved.getAddress(),
                saved.getAddressNumber(),
                saved.getNeighborhood(),
                saved.getCity(),
                saved.getState(),
                saved.getComplement()
        );
    }
}