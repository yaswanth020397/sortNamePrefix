package com.example.sortnamesprefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/sort")
    public List<Customer> getCustomersByPrefix(@RequestParam String prefix) {
        List<Customer> customers = customerRepository.findAll();

        return customers.parallelStream()
                .filter(customer -> customer.getName().startsWith(prefix))
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }
}