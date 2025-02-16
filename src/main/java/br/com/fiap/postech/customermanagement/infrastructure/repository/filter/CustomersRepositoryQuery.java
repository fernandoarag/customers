package br.com.fiap.postech.customermanagement.infrastructure.repository.filter;

import br.com.fiap.postech.customermanagement.infrastructure.entity.CustomerEntity;

import java.util.List;

public interface CustomersRepositoryQuery {

    List<CustomerEntity> filter(CustomerFilter customerFilter);
}
