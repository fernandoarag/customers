package br.com.fiap.postech.customers.gateway.database.jpa.repository;

import br.com.fiap.postech.customers.gateway.database.jpa.entity.CustomerEntity;
import br.com.fiap.postech.customers.gateway.database.jpa.repository.filter.CustomersRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, CustomersRepositoryQuery {

    Optional<CustomerEntity> findCustomerEntityByEmail(final String email);

}