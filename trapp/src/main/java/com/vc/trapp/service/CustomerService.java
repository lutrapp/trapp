package com.vc.trapp.service;

import com.vc.trapp.record.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    Optional<Customer> getCustomerById(Long id);

}
