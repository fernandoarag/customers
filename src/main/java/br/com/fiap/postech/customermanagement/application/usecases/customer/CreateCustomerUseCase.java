package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.domain.model.Customer;

/**
 * Use case for creating a customer.
 */
public interface CreateCustomerUseCase {

    /**
     * Executes the use case to create a customer.
     *
     * @param customer the customer to create
     * @return the created customer
     */
    Customer execute(Customer customer);
}