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

    @PostMapping("/orders/new")
    public void addOrder(@RequestBody Order order){
        if (orderRepo.findById(order.getId()).isPresent()){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        else{
            orderRepo.save(order);
        }
    }

    @PatchMapping("/orders/patch")
    public void patchOrder(@RequestBody Order updatedOrder){
        Order order = orderRepo.findById(updatedOrder.getId()).get();

        if (order != null){
            if(updatedOrder.getCustomerID() != null){
                order.setCustomerID(updatedOrder.getCustomerID());
            }
            if(updatedOrder.getEmployeeID() != null){
                order.setEmployeeID(updatedOrder.getEmployeeID());
            }
            if(updatedOrder.getOrderDate() != null){
                order.setOrderDate(updatedOrder.getOrderDate());
            }
            if(updatedOrder.getRequiredDate() != null){
                order.setRequiredDate(updatedOrder.getRequiredDate());
            }
            if(updatedOrder.getShippedDate() != null){
                order.setShippedDate(updatedOrder.getShippedDate());
            }
            if(updatedOrder.getShipVia() != null){
                order.setShipVia(updatedOrder.getShipVia());
            }
            if(updatedOrder.getFreight() != null){
                order.setFreight(updatedOrder.getFreight());
            }
            if(updatedOrder.getShipName() != null){
                order.setShipName(updatedOrder.getShipName());
            }
            if(updatedOrder.getShipAddress() != null){
                order.setShipAddress(updatedOrder.getShipAddress());
            }
            if(updatedOrder.getShipCity() != null){
                order.setShipCity(updatedOrder.getShipCity());
            }
            if(updatedOrder.getShipRegion() != null){
                order.setShipRegion(updatedOrder.getShipRegion());
            }
            if(updatedOrder.getShipPostalCode() != null){
                order.setShipPostalCode(updatedOrder.getShipPostalCode());
            }
            if(updatedOrder.getShipCountry() != null){
                order.setShipCountry(updatedOrder.getShipCountry());
            }
            orderRepo.save(order);
        }

    }

}
