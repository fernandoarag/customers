package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.infrastructure.repository.filter.CustomerFilter;
import br.com.fiap.postech.customermanagement.interfaces.gateway.database.CustomerGateway;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation of the FindCustomerUseCase interface.
 * Handles finding customers based on specific filters.
 */
@Service
public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

    private final CustomerGateway customerGateway;

    /**
     * Constructs a new FindCustomerUseCaseImpl with the specified CustomerGateway.
     *
     * @param customerGateway the gateway to access customer data
     */
    public FindCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    /**
     * Filters customers based on the provided filter criteria.
     *
     * @param customerFilter the filter criteria for finding customers
     * @return a list of customers that match the filter criteria
     */
    @Override
    public List<Customer> filter(CustomerFilter customerFilter) {
        return customerGateway.filter(customerFilter);
    }

}