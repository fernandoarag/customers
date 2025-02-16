package br.com.fiap.postech.customermanagement.application.usecases.customer;

import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerEmailCannotBeChangedException;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerNotFoundException;
import br.com.fiap.postech.customermanagement.application.gateway.CustomerGateway;
import br.com.fiap.postech.customermanagement.application.gateway.database.jpa.repository.filter.CustomerFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageCustomerUseCase {

    private final CustomerGateway customerGateway;

    public ManageCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public List<Customer> filterCustomer(CustomerFilter customerFilter) {
        return customerGateway.filter(customerFilter);
    }

    public Customer updateCustomerById(final Long id, final Customer customer) {
        customer.setId(id);
        customerGateway.findById(id).orElseThrow(() -> new CustomerNotFoundException("id", id.toString()));
        if (StringUtils.isNotBlank(customer.getEmail())) {
            throw new CustomerEmailCannotBeChangedException();
        }
        return customerGateway.save(customer);
    }

    public void deleteCustomerById(final Long id) {
        customerGateway.findById(id).orElseThrow(() -> new CustomerNotFoundException("id", id.toString()));
        customerGateway.deleteById(id);
    }

    public void deleteCustomerByEmail(final String email) {
        Customer customer = customerGateway.findCustomerEntityByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException("email", email));
        customerGateway.deleteById(customer.getId());
    }
}





