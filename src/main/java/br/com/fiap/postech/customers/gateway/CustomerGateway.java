package br.com.fiap.postech.customers.gateway;


import br.com.fiap.postech.customers.domain.Customers;
import br.com.fiap.postech.customers.gateway.database.jpa.repository.filter.domain.CustomersFilter;

import java.util.List;
import java.util.Optional;

public interface CustomerGateway {

    Customers save(final Customers customers); // Salva ou atualiza um cliente

    List<Customers> filter(final CustomersFilter customersFilter);

    Optional<Customers> findById(final Long id); // Busca cliente por ID

    Optional<Customers> findCustomerEntityByEmail(final String email);

    void validCustomerAlreadyExistsEmail(String email);

    void deleteById(final Long id); // Deleta um cliente pelo ID

}