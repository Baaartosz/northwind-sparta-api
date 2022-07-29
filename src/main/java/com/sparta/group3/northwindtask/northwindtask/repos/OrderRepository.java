package com.sparta.group3.northwindtask.northwindtask.repos;

import com.sparta.group3.northwindtask.northwindtask.entities.Customer;
import com.sparta.group3.northwindtask.northwindtask.entities.Employee;
import com.sparta.group3.northwindtask.northwindtask.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    void deleteAllByCustomerID(String id);

    List<Order> findByCustomerID(Customer customerID);

    List<Order> findByEmployeeID(Employee employeeid);

    List<Order> findByShipName(String shipName);

    List<Order> findByShipCountry(String shipCountry);

//    @Modifying
//    @Query("DELETE FROM Order c WHERE c.customer.id = ?1")
//    void deleteByCustomerId(String customerId);
}