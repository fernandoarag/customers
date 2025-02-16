package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailInvalidException;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.infrastructure.repository.filter.CustomerFilter;
import br.com.fiap.postech.customermanagement.interfaces.gateway.database.CustomerGateway;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

    private final CustomerGateway customerGateway;

    public FindCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<Customer> filter(CustomerFilter customerFilter) {
        if(StringUtils.isNotBlank(customerFilter.getEmail()) && !Customer.isEmailValid(customerFilter.getEmail())) {
            throw new CustomerEmailInvalidException();
        }
        return customerGateway.filter(customerFilter);
    }

}
