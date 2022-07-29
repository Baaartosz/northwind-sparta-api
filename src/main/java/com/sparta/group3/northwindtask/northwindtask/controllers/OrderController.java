package com.sparta.group3.northwindtask.northwindtask.controllers;

import com.sparta.group3.northwindtask.northwindtask.entities.Customer;
import com.sparta.group3.northwindtask.northwindtask.entities.Employee;
import com.sparta.group3.northwindtask.northwindtask.entities.Order;
import com.sparta.group3.northwindtask.northwindtask.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class OrderController {

    // OrderID, CustomerID, EmployeeID, ShipName, ShipCountry

    @Autowired
    OrderRepository orderRepo;

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    @GetMapping("/orders/id/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderRepo.findById(id).get();
    }

    @GetMapping("/orders/customerid/{customerid}")
    public List<Order> getOrderByCustomerID(@PathVariable Customer customerid){
        return orderRepo.findByCustomerID(customerid);
    }

    @GetMapping("/orders/employeeid/{employeeid}")
    public List<Order> getOrderByEmployeeID(@PathVariable Employee employeeid){
        return orderRepo.findByEmployeeID(employeeid);
    }

    @GetMapping("/orders/shipname/{shipName}")
    public List<Order> getOrderByShipName(@PathVariable String shipName){
        return orderRepo.findByShipName(shipName);
    }

    @GetMapping("/orders/shipcountry/{shipCountry}")
    public List<Order> getOrderByShipCountry(@PathVariable String shipCountry){
        return orderRepo.findByShipCountry(shipCountry);
    }

}
