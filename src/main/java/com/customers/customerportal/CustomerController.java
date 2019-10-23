package com.customers.customerportal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping(value="/customer",  produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        Iterable<Customer> customers = repository.findAll();

        customers.forEach(list::add);
        return list;
    }

    @PostMapping(value="/postcustomer")
    public Customer postCustomer(@RequestBody Customer customer) {

        repository.save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail()));
        return customer;
    }

    @GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> findByLastName(@PathVariable String lastName) {

        return repository.findByLastName(lastName);
    }

    @DeleteMapping(value="/customer/{id}")
    public void deleteCustomer(@PathVariable long id){

        repository.delete(id);
    }
}
