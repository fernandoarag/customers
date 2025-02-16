package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailCannotBeBlankException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailInvalidException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerNotFoundException;
import br.com.fiap.postech.customermanagement.application.exception.custom.InvalidInputException;
import br.com.fiap.postech.customermanagement.interfaces.gateway.database.CustomerGateway;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private final CustomerGateway customerGateway;

    public DeleteCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public void deleteCustomerById(final Long customerID) {
        if(customerID == null) {
            throw new InvalidInputException("ID cannot be null");
        }
        customerGateway.findById(customerID).orElseThrow(() -> new CustomerNotFoundException("id", customerID.toString()));
        customerGateway.deleteById(customerID);
    }

    @Override
    public void deleteCustomerByEmail(final String email) {
        if(StringUtils.isBlank(email)) {
            throw new CustomerEmailCannotBeBlankException();
        }
        if(StringUtils.isNotBlank(email) && !Customer.isEmailValid(email)) {
            throw new CustomerEmailInvalidException();
        }
        Customer customer = customerGateway.findCustomerEntityByEmail(email).orElseThrow(() -> new CustomerNotFoundException("email", email));
        customerGateway.deleteById(customer.getId());
    }
}





