package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailCannotBeChangedException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerNotFoundException;
import br.com.fiap.postech.customermanagement.application.exception.custom.InvalidInputException;
import br.com.fiap.postech.customermanagement.interfaces.gateway.database.CustomerGateway;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public UpdateCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Customer updateCustomerById(final Long customerID, final Customer customer) {
        if(customerID == null) {
            throw new InvalidInputException("ID cannot be null");
        }
        if (StringUtils.isNotBlank(customer.getEmail())) {
            throw new CustomerEmailCannotBeChangedException();
        }

        customer.setId(customerID);
        customerGateway.findById(customerID).orElseThrow(() -> new CustomerNotFoundException("id", customerID.toString()));
        return customerGateway.save(customer);
    }
}
