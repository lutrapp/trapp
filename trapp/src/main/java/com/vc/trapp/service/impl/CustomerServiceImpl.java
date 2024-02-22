package com.vc.trapp.service.impl;

import com.vc.trapp.entity.CustomerDomain;
import com.vc.trapp.record.Customer;
import com.vc.trapp.repository.CustomerRepository;
import com.vc.trapp.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerDomain  customerDomain = CustomerDomain.builder()
                .customerId(customer.customerId())
                .email(customer.email())
                .name(customer.name())
                .cpf(customer.cpf())
                .build();

        CustomerDomain customerCreated = customerRepository.save(customerDomain);
        return  new Customer(customerCreated.getCustomerId(), customerCreated.getName(), customerCreated.getEmail(), customerCreated.getCpf());
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return Optional.empty();
    }
}
