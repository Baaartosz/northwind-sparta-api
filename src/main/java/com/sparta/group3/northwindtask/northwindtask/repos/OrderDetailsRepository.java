package com.sparta.group3.northwindtask.northwindtask.repos;

import com.sparta.group3.northwindtask.northwindtask.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, String> {

    OrderDetail findOrderDetailsByOrderID(String id);
    OrderDetail findOrderDetailsByProductID(String id);
    List<OrderDetail> findOrderDetailsByUnitPrice(String id);
    List<OrderDetail> findOrderDetailsByQuantity(String id);
    List<OrderDetail> findOrderDetailsByDiscount(String id);

    @Modifying
    @Query("DELETE FROM OrderDetail c WHERE c.id = ?1")
    void deleteByIdWithJPQL(String id);

}