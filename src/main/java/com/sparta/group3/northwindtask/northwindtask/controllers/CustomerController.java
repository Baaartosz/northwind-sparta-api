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

    @GetMapping("/customers/contactname/{contactName}")
    public Customer getCustomerByName(@PathVariable String contactName){
        return customerRepo.findByContactName(contactName);
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

   @GetMapping("/customers/address/{address}")
    public Customer getCustomerByAddress(@PathVariable String address)
   {
       return customerRepo.findByAddress(address);
   }

   @GetMapping("/customers/city/{city}")
   public List<Customer> getCustomerByCity(@PathVariable String city)
   {
       return customerRepo.findByCity(city);
   }

   @GetMapping("/customers/region/{region}")
   public List<Customer> getCustomerByRegion(@PathVariable String region)
   {
       return customerRepo.findByRegion(region);
   }

   @GetMapping("/customers/postalCode/{postalCode}")
   public Customer getCustomerByPostalCode(@PathVariable String postalCode)
   {
       return customerRepo.findByPostalCode(postalCode);
   }

   @GetMapping("customers/phone/{phone}")
   public Customer getCustomerByPhone(@PathVariable String phone)
   {
       return customerRepo.findByPhone(phone);
   }

   @GetMapping("customers/fax/{fax}")
   public Customer getCustomerByFax(@PathVariable String fax)
   {
       return customerRepo.findByFax(fax);
   }

    @PostMapping ("/customers/new")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addCustomer(@RequestBody Customer customer){
        if (customerRepo.findById(customer.getId()).isPresent()){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        else{
            customerRepo.save(customer);
        }
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
