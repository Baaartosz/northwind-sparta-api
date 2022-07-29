package com.sparta.group3.northwindtask.northwindtask.repos;

import com.sparta.group3.northwindtask.northwindtask.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    void deleteByLastName(String lastName);

    boolean existsByLastName(String lastName);

    Employee findByLastName(String lastName);
    List<Employee> findByTitle(String title);
    Employee findByFirstName(String firstName);
    Employee findByBirthDate(Integer birthDate);

    Employee findByHireDate(Integer hireDate);

    Employee findByAddress(String address);

    List<Employee> findByCity(String city);

    List<Employee> findByRegion(String region);

    Employee findByPostalCode(String postalCode);

    //Employee findByPhone(String homePhone);

    List<Employee> findByCountry(String country);

    //Employee findByExtension(String extension);
}