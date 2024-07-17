package com.kheang.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.create(customer));
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.update(id, customer));
    }
}
