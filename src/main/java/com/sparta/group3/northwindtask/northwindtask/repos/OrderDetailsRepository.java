//package com.sparta.group3.northwindtask.northwindtask.repos;
//
//import com.sparta.group3.northwindtask.northwindtask.entities.OrderDetail;
//import com.sparta.group3.northwindtask.northwindtask.entities.OrderDetailId;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface OrderDetailsRepository extends JpaRepository<OrderDetail, String> {
//
//    OrderDetail findOrderDetailsByOrderId(String id);
//    List<OrderDetail> findOrderDetailsByUnitPrice(String id);
//    List<OrderDetail> findOrderDetailsByQuantity(String id);
//    List<OrderDetail> findOrderDetailsByDiscount(String id);
//}