package br.com.fiap.postech.customermanagement.application.gateway.database.jpa.repository.filter;

import br.com.fiap.postech.customermanagement.application.gateway.database.jpa.entity.CustomerEntity;

import java.util.List;

public interface CustomersRepositoryQuery {

    List<CustomerEntity> filter(CustomerFilter customerFilter);
}
