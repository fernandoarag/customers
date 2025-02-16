package br.com.fiap.postech.customermanagement.application.gateway.database.jpa.repository;

import br.com.fiap.postech.customermanagement.application.gateway.database.jpa.entity.CustomerEntity;
import br.com.fiap.postech.customermanagement.application.gateway.database.jpa.repository.filter.CustomersRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, CustomersRepositoryQuery {

    Optional<CustomerEntity> findCustomerEntityByEmail(final String email);

}