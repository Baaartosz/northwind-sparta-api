package com.sparta.group3.northwindtask.northwindtask;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.group3.northwindtask.northwindtask.entities.Order;
import com.sparta.group3.northwindtask.northwindtask.repos.CustomerRepository;
import com.sparta.group3.northwindtask.northwindtask.repos.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest()
public class OrderTests {


    @Autowired
    private OrderRepository orderRepository;

    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    String serverURL = "http://localhost:8080";

    @Test
    @DisplayName("Get order by ID")
    void getById(){
        try{
            Order result = mapper.readValue(
                    new URL(serverURL + "/orders/id/10721"),
                    Order.class);
            Assertions.assertEquals(10721, result.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get order customerID")
    void getCustomerId(){
        try{
            Order result = mapper.readValue(
                    new URL(serverURL + "/orders/id/10721"),
                    Order.class);
            Assertions.assertEquals("QUICK", result.getCustomerID().getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get order employeeID")
    void getEmployeeId(){
        try{
            Order result = mapper.readValue(
                    new URL(serverURL + "/orders/id/10721"),
                    Order.class);
            Assertions.assertEquals(5, result.getEmployeeID().getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get order ship name")
    void getShipName(){
        try{
            Order result = mapper.readValue(
                    new URL(serverURL + "/orders/id/10721"),
                    Order.class);
            Assertions.assertEquals("QUICK-Stop", result.getShipName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get order ship country")
    void getShipCountry(){
        try{
            Order result = mapper.readValue(
                    new URL(serverURL + "/orders/id/10721"),
                    Order.class);
            Assertions.assertEquals("Germany", result.getShipCountry());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
