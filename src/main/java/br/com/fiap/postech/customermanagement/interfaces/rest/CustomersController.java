package br.com.fiap.postech.customermanagement.interfaces.rest;

import br.com.fiap.postech.customermanagement.application.usecases.customer.CreateCustomerUseCase;
import br.com.fiap.postech.customermanagement.application.usecases.customer.DeleteCustomerUseCase;
import br.com.fiap.postech.customermanagement.application.usecases.customer.FindCustomerUseCase;
import br.com.fiap.postech.customermanagement.application.usecases.customer.UpdateCustomerUseCase;
import br.com.fiap.postech.customermanagement.domain.model.Customer;
import br.com.fiap.postech.customermanagement.infrastructure.repository.filter.CustomerFilter;
import br.com.fiap.postech.customermanagement.interfaces.adapters.CustomerRestAdapter;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerRequestDTO;
import br.com.fiap.postech.customermanagement.interfaces.dtos.CustomerResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomersController {

    private final CustomerRestAdapter customerRestAdapter;
    private final FindCustomerUseCase findCustomerUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;


    public CustomersController(
            CustomerRestAdapter customerRestAdapter,
            FindCustomerUseCase findCustomerUseCase,
            CreateCustomerUseCase createCustomerUseCase,
            UpdateCustomerUseCase updateCustomerUseCase,
            DeleteCustomerUseCase deleteCustomerUseCase
    ) {
        this.customerRestAdapter = customerRestAdapter;
        this.findCustomerUseCase = findCustomerUseCase;
        this.createCustomerUseCase = createCustomerUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> filter(final CustomerFilter customerFilter) {
        List<Customer> customers = findCustomerUseCase.filter(customerFilter);
        List<CustomerResponseDTO> responseList = customers.stream().map(customerRestAdapter::toResponse).toList();
        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> create(@RequestBody CustomerRequestDTO requestDTO) {
        Customer customer = customerRestAdapter.toDomain(requestDTO);
        Customer savedCustomer = createCustomerUseCase.execute(customer);
        CustomerResponseDTO responseDTO = customerRestAdapter.toResponse(savedCustomer);
        return ResponseEntity.created(URI.create("/customers/" + responseDTO.id())).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomerById(@PathVariable final Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = updateCustomerUseCase.updateCustomerById(id, customer);
        CustomerResponseDTO responseDTO = customerRestAdapter.toResponse(updatedCustomer);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable final Long id) {
        deleteCustomerUseCase.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("email/{email}")
    public ResponseEntity<Void> deleteCustomerByEmail(@PathVariable final String email) {
        deleteCustomerUseCase.deleteCustomerByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
