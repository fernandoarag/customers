package br.com.fiap.postech.customers.usecase;

import br.com.fiap.postech.customers.domain.Customers;
import br.com.fiap.postech.customers.exception.CustomerAlreadyExistsException;
import br.com.fiap.postech.customers.exception.CustomerEmailCannotBeChangedException;
import br.com.fiap.postech.customers.exception.CustomerNotFoundException;
import br.com.fiap.postech.customers.gateway.CustomerGateway;
import br.com.fiap.postech.customers.gateway.database.jpa.repository.filter.domain.CustomersFilter;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageCustomerUseCase {

    private final CustomerGateway customerGateway;

    public ManageCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public List<Customers> filterCustomer(CustomersFilter customersFilter) {
        return customerGateway.filter(customersFilter);
    }

    public Customers updateCustomerById(final Long id, final Customers customers) {
        customers.setId(id);
        customerGateway.findById(id).orElseThrow(() -> new CustomerNotFoundException("id", id.toString()));
        if (StringUtils.isNotBlank(customers.getEmail())) {
            throw new CustomerEmailCannotBeChangedException();
        }
        return customerGateway.save(customers);
    }

    public void deleteCustomerById(final Long id) {
        customerGateway.findById(id).orElseThrow(() -> new CustomerNotFoundException("id", id.toString()));
        customerGateway.deleteById(id);
    }

    public void deleteCustomerByEmail(final String email) {
        final Optional<Customers> currentCustomer = customerGateway.findCustomerEntityByEmail(email);
        if (currentCustomer.isPresent()) {
            customerGateway.deleteById(currentCustomer.get().getId());
        } else {
            throw new CustomerNotFoundException("email", email);
        }
    }
}





