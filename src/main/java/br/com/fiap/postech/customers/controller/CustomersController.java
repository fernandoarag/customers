package br.com.fiap.postech.customers.controller;

import br.com.fiap.postech.customers.domain.Customers;
import br.com.fiap.postech.customers.exception.CustomerAlreadyExistsException;
import br.com.fiap.postech.customers.gateway.database.jpa.repository.filter.domain.CustomersFilter;
import br.com.fiap.postech.customers.usecase.CreateCustomerUseCase;
import br.com.fiap.postech.customers.usecase.ManageCustomerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final ManageCustomerUseCase manageCustomerUseCase;

    public CustomersController(CreateCustomerUseCase createCustomerUseCase, ManageCustomerUseCase manageCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.manageCustomerUseCase = manageCustomerUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Customers>> getCustomerByFilter(final CustomersFilter customersFilter) {
        return ResponseEntity.ok(manageCustomerUseCase.filterCustomer(customersFilter));
    }

    @PostMapping
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customers) {
        try {
            Customers createdCustomers = createCustomerUseCase.execute(customers);
            return ResponseEntity.ok(createdCustomers);
        } catch (CustomerAlreadyExistsException e) {
            throw new CustomerAlreadyExistsException(customers.getEmail());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomerById(@PathVariable final Long id, @RequestBody Customers customers) {
        Customers updatedCustomers = manageCustomerUseCase.updateCustomerById(id, customers);
        return ResponseEntity.ok(updatedCustomers);
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
