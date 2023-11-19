package com.example.sortnamesprefix;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void initDefaultCustomers() {
        List<Customer> defaultCustomers = Arrays.asList(
                new Customer(null, "Jakk"),
                new Customer(null, "Yash"),
                new Customer(null, "Prince"),
                new Customer(null, "Ram"),
                new Customer(null, "Prasad"),
                new Customer(null, "Prakash"),
                new Customer(null, "Yasaswin"),
                new Customer(null, "Rakesh"),
                new Customer(null, "Praveen"),
                new Customer(null, "Jayanth")

                // Add more default customers as needed
        );

        customerRepository.saveAll(defaultCustomers);
    }
}
