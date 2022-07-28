package com.sparta.group3.northwindtask.northwindtask.controllers;

import com.sparta.group3.northwindtask.northwindtask.entities.Customer;
import com.sparta.group3.northwindtask.northwindtask.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    OrderRepository orderRepo;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return customerRepo.findById(id).get();
    }
    @DeleteMapping("/customers/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable String id){ // FIXME broken af
        Customer target = customerRepo.findById(id).get();

        orderRepo.deleteAllByCustomerID(id);
        customerRepo.delete(target);
    }
    @DeleteMapping("/customers/delete2/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomerById2(@PathVariable String id){ // FIXME broken af
        Customer customer = customerRepo.findById(id).get();
        orderRepo.deleteAllByCustomerID(customer.getId());
        customerRepo.deleteByIdWithJPQL(customer.getId());
    }
    /*
        Cannot delete or update a parent row: a foreign key constraint fails
        (`northwind`.`orders`, CONSTRAINT `FK_Orders_Customers` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`))
     */
}
