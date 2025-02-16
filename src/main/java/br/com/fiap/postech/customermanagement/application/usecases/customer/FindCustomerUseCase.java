package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.infrastructure.repository.filter.CustomerFilter;

import java.util.List;

public interface FindCustomerUseCase {

    List<Customer> filter(final CustomerFilter customerFilter);

}
