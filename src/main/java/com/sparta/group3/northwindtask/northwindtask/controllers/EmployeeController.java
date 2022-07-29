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

    @GetMapping("/Employees/lastname/{LastName}")
    public Employee getEmployeeByLastName(@PathVariable String LastName){
        return employeeRepo.findByLastName(LastName);
    }

    @GetMapping("/Employees/firstname/{FirstName}")
    public Employee getEmployeeByFirstName(@PathVariable String FirstName){
        return employeeRepo.findByFirstName(FirstName);
    }

    @GetMapping("/Employees/TitleOfCourtesy/{titleOfCourtesy}")
    public List<Employee> getEmployeeByTitle(@PathVariable String titleOfCourtesy)
    {
        return employeeRepo.findByTitle(titleOfCourtesy);
    }

    @GetMapping("/Employees/BirthDate/{birthDate}")
    public Employee getEmployeeByBirthDate(@PathVariable Integer birthDate){
        return employeeRepo.findByBirthDate(birthDate);
    }

    @GetMapping("/Employees/HireDate/{hireDate}")
    public Employee getEmployeeByHireDate(@PathVariable Integer hireDate){
        return employeeRepo.findByHireDate(hireDate);
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
    @GetMapping("/Employees/Country/{country}")
    public List<Employee> getEmployeeByCountry(@PathVariable String country)
    {
        return employeeRepo.findByCountry(country);
    }

    @GetMapping("Employees/HomePhone/{homePhone}")
    public Employee getEmployeeByHomePhone(@PathVariable String homePhone)
    {
        return employeeRepo.findByPhone(homePhone);
    }

    @GetMapping("Employees/Extension/{extension}")
    public Employee getEmployeeByFax(@PathVariable String extension)
    {
        return employeeRepo.findByExtension(extension);
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
            if(updatedEmployee.getLastName() != null) {
                Employee.setLastName(updatedEmployee.getLastName());
            }
            if(updatedEmployee.getFirstName() != null){
                Employee.setFirstName(updatedEmployee.getFirstName());
            }
            if(updatedEmployee.getTitle() != null){
                Employee.setTitle(updatedEmployee.getTitle());
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
            if (updatedEmployee.getHomePhone()!= null){
                Employee.setHomePhone(updatedEmployee.getHomePhone());
            }
            employeeRepo.save(Employee);
            if (updatedEmployee.getHireDate()!= null){
                Employee.setHireDate(updatedEmployee.getHireDate());
            }
            employeeRepo.save(Employee);
            if (updatedEmployee.getBirthDate()!= null){
                Employee.setBirthDate(updatedEmployee.getBirthDate());
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
    public void deleteEmployeeById(@PathVariable Integer id){
        employeeRepo.delete(employeeRepo.getReferenceById(id));
    }
}
