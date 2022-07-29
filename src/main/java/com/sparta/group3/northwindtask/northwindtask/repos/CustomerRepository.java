package com.sparta.group3.northwindtask.northwindtask.repos;

import com.sparta.group3.northwindtask.northwindtask.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByCompanyName(String companyName);
    Customer findByContactName(String contactName);
    List<Customer> findByContactTitle(String contactTitle);
    Customer findByAddress(String address);
    List<Customer> findByCity(String city);
    List<Customer> findByRegion(String region);
    Customer findByPostalCode(String postalCode);
    Customer findByPhone(String phone);
    Customer findByFax(String fax);
    @Modifying
    @Query("DELETE FROM Customer c WHERE c.id = ?1")
    void deleteByIdWithJPQL(String id);




    //https://stackoverflow.com/a/64284372
    //https://www.baeldung.com/jpa-transaction-required-exception
}