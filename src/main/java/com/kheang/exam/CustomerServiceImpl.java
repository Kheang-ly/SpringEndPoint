package com.kheang.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer byId = getById(id);
        byId.setFirstname(customer.getFirstname());
        byId.setLastname(customer.getLastname());
        byId.setPhone(customer.getPhone());
        return customerRepository.save(byId);
    }
}
