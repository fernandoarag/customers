package br.com.fiap.postech.customermanagement.interfaces.adapters;

import br.com.fiap.postech.customermanagement.domain.factory.CustomerFactory;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerRequestDTO;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerRestAdapter {

    CustomerFactory customerFactory;

    public CustomerRestAdapter(CustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
    }

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
