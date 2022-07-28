package com.sparta.group3.northwindtask.northwindtask.repos;

import com.sparta.group3.northwindtask.northwindtask.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}