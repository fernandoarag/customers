package br.com.fiap.postech.customermanagement.infrastructure.repository;

import br.com.fiap.postech.customermanagement.infrastructure.entity.CustomerEntity;
import br.com.fiap.postech.customermanagement.infrastructure.repository.filter.CustomersRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, CustomersRepositoryQuery {

    Optional<CustomerEntity> findCustomerEntityByEmail(final String email);

}