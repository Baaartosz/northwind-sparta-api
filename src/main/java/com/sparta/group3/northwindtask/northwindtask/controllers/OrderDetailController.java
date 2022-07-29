package com.sparta.group3.northwindtask.northwindtask.controllers;

import com.sparta.group3.northwindtask.northwindtask.repos.OrderDetailsRepository;
import com.sparta.group3.northwindtask.northwindtask.entities.OrderDetail;
import com.sparta.group3.northwindtask.northwindtask.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class OrderDetailController {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    OrderRepository orderRepo;

    @GetMapping("/orderdetails")
    public List<OrderDetail> getAllOrderDetails(){
        return orderDetailsRepository.findAll();
    }

    @GetMapping("/orderdetails/id/{id}")
    public OrderDetail getOrderDetailsByID(@PathVariable String id){
        return orderDetailsRepository.findById(id).get();
    }

    @GetMapping("/orderdetails/productid/{productid}")
    public OrderDetail getOrderDetailsByProductID(@PathVariable String productid){
        return orderDetailsRepository.findOrderDetailsByProductID(productid);
    }

    @GetMapping("/orderdetails/unitprice/{unitprice}")
    public List<OrderDetail> getOrderDetailsByUnitPrice(@PathVariable String unitprice) {
        return orderDetailsRepository.findOrderDetailsByUnitPrice(unitprice);
    }

    @GetMapping("/orderdetails/quantity/{quantity}")
    public List<OrderDetail> getOrderDetailsByQuantity(@PathVariable String quantity){
        return orderDetailsRepository.findOrderDetailsByQuantity(quantity);
    }

    @GetMapping("/orderdetails/discount/{discount}")
    public List<OrderDetail> getOrderDetailsByDiscount(@PathVariable String discount) {
        return orderDetailsRepository.findOrderDetailsByDiscount(discount);
    }

    @PostMapping("/orderdetails/new")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addOrderDetails(@RequestBody OrderDetail orderDetail){
        if (orderDetailsRepository.findById(orderDetail.getId().toString()).isPresent()){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        else{
            orderDetailsRepository.save(orderDetail);
        }
    }

    @PatchMapping("/orderdetails/patch")
    public void patchOrderDetails(@RequestBody OrderDetail updatedOrderDetail){
        OrderDetail orderDetail = orderDetailsRepository.findById(updatedOrderDetail.getId().toString()).get();
        if (orderDetail != null){
            if(updatedOrderDetail.getId() != null) {
                orderDetail.setId(updatedOrderDetail.getId());
            }
            if (updatedOrderDetail.getId().getProductID() != null){
                orderDetail.getId().setProductID(
                        updatedOrderDetail.getId().getProductID()
                );
            }
            if(updatedOrderDetail.getUnitPrice() != null){
                orderDetail.setUnitPrice(updatedOrderDetail.getUnitPrice());
            }
            if(updatedOrderDetail.getQuantity() != null){
                orderDetail.setQuantity(updatedOrderDetail.getQuantity());
            }
            if (updatedOrderDetail.getDiscount() != null){
                orderDetail.setDiscount(updatedOrderDetail.getDiscount());
            }
            orderDetailsRepository.save(orderDetail);
        }


    }

    @PutMapping("/orderdetails/update")
    public void updateOrderDetails(@RequestBody OrderDetail orderDetail){
        orderDetailsRepository.save(orderDetail);
    }

    @DeleteMapping("/orderdetails/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteOrderDetailsByID(@PathVariable String id){ // FIXME broken af
        orderDetailsRepository.delete(orderDetailsRepository.getReferenceById(id));
    }
}
