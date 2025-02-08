package br.com.fiap.postech.customers.gateway.database.jpa.repository.filter;

import br.com.fiap.postech.customers.gateway.database.jpa.entity.CustomerEntity;
import br.com.fiap.postech.customers.gateway.database.jpa.repository.filter.domain.CustomersFilter;

import java.util.List;

public interface CustomersRepositoryQuery  {

    public List<CustomerEntity> filter(CustomersFilter customersFilter);
}
