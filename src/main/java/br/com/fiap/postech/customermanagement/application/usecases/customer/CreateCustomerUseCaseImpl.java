package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.application.gateway.CustomerGateway;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public CreateCustomerUseCaseImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer execute(Customer customer) {
//        customerGateway.validCustomerAlreadyExistsEmail(customer.getEmail());
        return customerGateway.save(customer);
    }
}
