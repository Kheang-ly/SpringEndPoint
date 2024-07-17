package com.kheang.exam;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    Customer getById(Long id);
    List<Customer> getAll();

    Customer update(Long id, Customer customer);

}
