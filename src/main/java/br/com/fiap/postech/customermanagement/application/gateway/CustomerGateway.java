package br.com.fiap.postech.customermanagement.application.gateway;


import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.application.gateway.database.jpa.repository.filter.CustomerFilter;

import java.util.List;
import java.util.Optional;

public interface CustomerGateway {

    Customer save(final Customer customer); // Salva ou atualiza um cliente

    List<Customer> filter(final CustomerFilter customerFilter);

    Optional<Customer> findById(final Long id); // Busca cliente por ID

    Optional<Customer> findCustomerEntityByEmail(final String email);

    void validCustomerAlreadyExistsEmail(String email);

    void deleteById(final Long id); // Deleta um cliente pelo ID

}