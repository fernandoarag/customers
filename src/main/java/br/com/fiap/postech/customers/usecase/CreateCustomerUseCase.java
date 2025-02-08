package br.com.fiap.postech.customers.usecase;

import br.com.fiap.postech.customers.domain.Customers;
import br.com.fiap.postech.customers.gateway.CustomerGateway;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public CreateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customers execute(Customers customers) {
        customerGateway.validCustomerAlreadyExistsEmail(customers.getEmail());
        return customerGateway.save(customers);
    }
}
