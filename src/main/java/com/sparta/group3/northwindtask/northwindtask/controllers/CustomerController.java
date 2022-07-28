package com.sparta.group3.northwindtask.northwindtask.controllers;

import com.sparta.group3.northwindtask.northwindtask.entities.Customer;
import com.sparta.group3.northwindtask.northwindtask.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;


    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return repo.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return repo.findById(id).get();
    }
    @DeleteMapping("/customers/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable String id){
        Customer target = repo.findById(id).get();
        repo.delete(target);
    }
    @PostMapping ("/customers/new")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCustomer(@RequestBody Customer customer){
        repo.save(customer);
    }
}
