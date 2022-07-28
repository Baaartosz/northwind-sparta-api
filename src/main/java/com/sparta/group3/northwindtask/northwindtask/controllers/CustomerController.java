package com.sparta.group3.northwindtask.northwindtask.controllers;

import com.sparta.group3.northwindtask.northwindtask.entities.Customer;
import com.sparta.group3.northwindtask.northwindtask.entities.Order;
import com.sparta.group3.northwindtask.northwindtask.repos.CustomerRepository;
import com.sparta.group3.northwindtask.northwindtask.repos.OrderRepository;
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

    @GetMapping("/customers/id/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return customerRepo.findById(id).get();
    }

    @GetMapping("/customers/contactname/{contactName}") // FIXME does not find by name
    public Customer getCustomerByName(@PathVariable String name){
        return customerRepo.findByContactName(name);
    }

    @GetMapping("/customers/contacttitle/{contactTitle}")
    public List<Customer> getCustomerByContactTitle(@PathVariable String contactTitle)
    {
        return customerRepo.findByContactTitle(contactTitle);
    }

    @GetMapping("/customers/company/{companyName}")
    public List<Customer> getCustomerByCompanyName(@PathVariable String companyName){
        return customerRepo.findByCompanyName(companyName);
    }

//    @GetMapping("/customers/{Address}")
//    public


    @PostMapping ("/customers/new")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCustomer(@RequestBody Customer customer){
        if (customerRepo.findById(customer.getId()).isPresent()){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        else{
            customerRepo.save(customer);
        }
        return;
    }

    @PatchMapping("/customers/patch")
    public void patchCustomer(@RequestBody Customer updatedCustomer){
        Customer customer = customerRepo.findById(updatedCustomer.getId()).get();

        if (customer != null){
            if(updatedCustomer.getCompanyName() != null) {
                customer.setCompanyName(updatedCustomer.getCompanyName());
            }
            if(updatedCustomer.getContactName() != null){
                customer.setContactName(updatedCustomer.getContactName());
            }
            if(updatedCustomer.getContactTitle() != null){
                customer.setContactTitle(updatedCustomer.getContactTitle());
            }
            if (updatedCustomer.getAddress() != null){
                customer.setAddress(updatedCustomer.getAddress());
            }
            if (updatedCustomer.getCity() != null){
                customer.setCity(updatedCustomer.getCity());
            }
            if (updatedCustomer.getRegion() != null){
                customer.setRegion(updatedCustomer.getRegion());
            }
            if (updatedCustomer.getPostalCode() != null){
                customer.setPostalCode(updatedCustomer.getPostalCode());
            }
            if (updatedCustomer.getCountry() != null){
                customer.setCountry(updatedCustomer.getCountry());
            }
            if (updatedCustomer.getPhone() != null){
                customer.setPhone(updatedCustomer.getPhone());
            }
            customerRepo.save(customer);
        }


    }

    @PutMapping("/customers/update")
    public void updateCustomer(@RequestBody Customer updatedCustomer){
        customerRepo.save(updatedCustomer);
    }

    @DeleteMapping("/customers/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable String id){ // FIXME broken af
        customerRepo.delete(customerRepo.getReferenceById(id));
    }
}
