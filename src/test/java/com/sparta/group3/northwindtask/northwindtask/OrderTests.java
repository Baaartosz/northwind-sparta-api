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
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@SpringBootTest()
public class OrderTests {


    @Autowired
    private OrderRepository orderRepository;

    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    String serverURL = "http://localhost";

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

    @Test
    @DisplayName("Add order")
    void addOrder() {
        if (orderRepository.existsById(11100)) {
            orderRepository.deleteById(11100);
        }

        //______________________________________BODY MAKER_________________
        var values = new HashMap<String, String>() {{
            put("id", "11100");
            put("customerID", "'BRAND'");
            put("employeeID", "8");
            put("orderDate", "1996-07-22 00:00:00");
            put("requiredDate", "1996-08-19 00:00:00");
            put("shippedDate", "1996-07-25 00:00:00");
            put("shipVia", "3");
            put("freight", "48.2900");
            put("shipName", "Rattlesnake Canyon Grocery");
            put("shipAddress", "2817 Milton Dr.");
            put("shipCity", "Chicago");
            put("shipRegion", "NM");
            put("shipPostalCode", "'87110'");
            put("shipCountry", "USA");
        }};

        try {
            String requestBody = mapper.writeValueAsString(values);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverURL + "/orders/new")) //CHANGE THE LOCATION TO SEND BODY TO
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        //____________________________________END OF BODY MAKER___________________________

//        try {
//            Customer result = mapper.readValue(
//                    new URL("http://localhost/customers/id/AAAAA"),
//                    Customer.class);
//            Assertions.assertNotEquals(null, result);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } // VVVVVVVVVVVVV
        Assertions.assertNotEquals(null, orderRepository.findById(11100).get());
        orderRepository.deleteById(11100);
    }

}
