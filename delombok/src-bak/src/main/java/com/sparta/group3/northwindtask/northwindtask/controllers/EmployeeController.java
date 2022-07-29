package com.sparta.group3.northwindtask.northwindtask.controllers;

import com.sparta.group3.northwindtask.northwindtask.entities.Employee;
import com.sparta.group3.northwindtask.northwindtask.repos.EmployeeRepository;
import com.sparta.group3.northwindtask.northwindtask.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepo;
    @Autowired
    OrderRepository orderRepo;

    @GetMapping("/Employees")
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    @GetMapping("/Employees/id/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeRepo.findById(id).get();
    }

    @GetMapping("/Employees/contactname/{contactName}")
    public Employee getEmployeeByName(@PathVariable String contactName){
        return employeeRepo.findByContactName(contactName);
    }

    @GetMapping("/Employees/contacttitle/{contactTitle}")
    public List<Employee> getEmployeeByContactTitle(@PathVariable String contactTitle)
    {
        return employeeRepo.findByContactTitle(contactTitle);
    }

    @GetMapping("/Employees/company/{companyName}")
    public List<Employee> getEmployeeByCompanyName(@PathVariable String companyName){
        return employeeRepo.findByCompanyName(companyName);
    }

    @GetMapping("/Employees/address/{address}")
    public Employee getEmployeeByAddress(@PathVariable String address)
    {
        return employeeRepo.findByAddress(address);
    }

    @GetMapping("/Employees/city/{city}")
    public List<Employee> getEmployeeByCity(@PathVariable String city)
    {
        return employeeRepo.findByCity(city);
    }

    @GetMapping("/Employees/region/{region}")
    public List<Employee> getEmployeeByRegion(@PathVariable String region)
    {
        return employeeRepo.findByRegion(region);
    }

    @GetMapping("/Employees/postalCode/{postalCode}")
    public Employee getEmployeeByPostalCode(@PathVariable String postalCode)
    {
        return employeeRepo.findByPostalCode(postalCode);
    }

    @GetMapping("Employees/phone/{phone}")
    public Employee getEmployeeByPhone(@PathVariable String phone)
    {
        return employeeRepo.findByPhone(phone);
    }

    @GetMapping("Employees/fax/{fax}")
    public Employee getEmployeeByFax(@PathVariable String fax)
    {
        return employeeRepo.findByFax(fax);
    }

    @PostMapping("/Employees/new")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addEmployee(@RequestBody Employee Employee){
        if (employeeRepo.findById(Employee.getId()).isPresent()){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        else{
            employeeRepo.save(Employee);
        }
    }

    @PatchMapping("/Employees/patch")
    public void patchEmployee(@RequestBody Employee updatedEmployee){
        Employee Employee = employeeRepo.findById(updatedEmployee.getId()).get();

        if (Employee != null){
            if(updatedEmployee.getCompanyName() != null) {
                Employee.setCompanyName(updatedEmployee.getCompanyName());
            }
            if(updatedEmployee.getContactName() != null){
                Employee.setContactName(updatedEmployee.getContactName());
            }
            if(updatedEmployee.getContactTitle() != null){
                Employee.setContactTitle(updatedEmployee.getContactTitle());
            }
            if (updatedEmployee.getAddress() != null){
                Employee.setAddress(updatedEmployee.getAddress());
            }
            if (updatedEmployee.getCity() != null){
                Employee.setCity(updatedEmployee.getCity());
            }
            if (updatedEmployee.getRegion() != null){
                Employee.setRegion(updatedEmployee.getRegion());
            }
            if (updatedEmployee.getPostalCode() != null){
                Employee.setPostalCode(updatedEmployee.getPostalCode());
            }
            if (updatedEmployee.getCountry() != null){
                Employee.setCountry(updatedEmployee.getCountry());
            }
            if (updatedEmployee.getPhone() != null){
                Employee.setPhone(updatedEmployee.getPhone());
            }
            employeeRepo.save(Employee);
        }


    }

    @PutMapping("/Employees/update")
    public void updateEmployee(@RequestBody Employee updatedEmployee){
        employeeRepo.save(updatedEmployee);
    }

    @DeleteMapping("/Employees/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable String id){ // FIXME broken af
        employeeRepo.delete(employeeRepo.getReferenceById(id));
    }
}
