package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.domain.model.Customer;

public interface UpdateCustomerUseCase {

    Customer updateCustomerById(final Long id, final Customer customer);

}
