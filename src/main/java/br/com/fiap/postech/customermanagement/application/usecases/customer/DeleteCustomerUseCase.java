package br.com.fiap.postech.customermanagement.application.usecases.customer;

public interface DeleteCustomerUseCase {

    void deleteCustomerById(final Long id);

    void deleteCustomerByEmail(final String email);

}
