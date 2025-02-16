package br.com.fiap.postech.customermanagement.controller;

import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.application.exception.custom.CustomerAlreadyExistsException;
import br.com.fiap.postech.customermanagement.application.gateway.database.jpa.repository.filter.CustomerFilter;
import br.com.fiap.postech.customermanagement.application.usecases.customer.CreateCustomerUseCaseImpl;
import br.com.fiap.postech.customermanagement.application.usecases.customer.ManageCustomerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    private final CreateCustomerUseCaseImpl createCustomerUseCaseImpl;
    private final ManageCustomerUseCase manageCustomerUseCase;

    public CustomersController(CreateCustomerUseCaseImpl createCustomerUseCaseImpl, ManageCustomerUseCase manageCustomerUseCase) {
        this.createCustomerUseCaseImpl = createCustomerUseCaseImpl;
        this.manageCustomerUseCase = manageCustomerUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomerByFilter(final CustomerFilter customerFilter) {
        return ResponseEntity.ok(manageCustomerUseCase.filterCustomer(customerFilter));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer createdCustomer = createCustomerUseCaseImpl.execute(customer);
            return ResponseEntity.ok(createdCustomer);
        } catch (CustomerAlreadyExistsException e) {
            throw new CustomerAlreadyExistsException(customer.getEmail());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable final Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = manageCustomerUseCase.updateCustomerById(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable final Long id) {
        manageCustomerUseCase.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("email/{email}")
    public ResponseEntity<Void> deleteCustomerByEmail(@PathVariable final String email) {
        manageCustomerUseCase.deleteCustomerByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
