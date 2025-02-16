package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerAlreadyExistsException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailCannotBeBlankException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailInvalidException;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.interfaces.gateway.database.CustomerGateway;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public CreateCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(Customer customer) {
        if(StringUtils.isBlank(customer.getEmail())) {
            throw new CustomerEmailCannotBeBlankException();
        }
        if(!Customer.isEmailValid(customer.getEmail())) {
            throw new CustomerEmailInvalidException();
        }
        if (customerGateway.findCustomerEntityByEmail(customer.getEmail()).isPresent()) {
            throw new CustomerAlreadyExistsException(customer.getEmail());
        }
        return customerGateway.save(customer);
    }
}
