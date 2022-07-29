//package com.sparta.group3.northwindtask.northwindtask.ordedetails;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sparta.group3.northwindtask.northwindtask.repos.OrderDetailsRepository;
//import com.sparta.group3.northwindtask.northwindtask.entities.OrderDetail;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URL;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.HashMap;
//
//@SpringBootTest()
//public class OrderDetailsTests {
//
//    @Autowired
//    private OrderDetailsRepository orderDetailsRepository;
//
//    private ObjectMapper mapper = new ObjectMapper();
//
//    String serverURL = "http://localhost";
//
//    //_________________________________________________________________________GET TESTS________
//
//    @Test
//    @DisplayName("Get order details by ID")
//    void getById() {
//        try {
//            OrderDetail result = mapper.readValue(
//                    new URL(serverURL + "/orderdetails/id/10248"),
//                    OrderDetail.class);
//            Assertions.assertEquals("10248", result.getId());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    @DisplayName("Get order details product ID")
//    void getProductID() {
//        try {
//            OrderDetail result = mapper.readValue(
//                    new URL(serverURL + "/orderdetails/id/10248"),
//                    OrderDetail.class);
//            Assertions.assertEquals("11", result.getId().getProductID());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    @DisplayName("Get order details unit price")
//    void getUnitPrice() {
//        try {
//            OrderDetail result = mapper.readValue(
//                    new URL(serverURL + "/orderdetails/id/10248"),
//                    OrderDetail.class);
//            Assertions.assertEquals("14.0000", result.getUnitPrice());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    @DisplayName("Get order details quantity")
//    void getQuantity() {
//        try {
//            OrderDetail result = mapper.readValue(
//                    new URL(serverURL + "/orderdetails/id/10248"),
//                    OrderDetail.class);
//            Assertions.assertEquals("12", result.getQuantity());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    @DisplayName("Get order details discount")
//    void getDiscount() {
//        try {
//            OrderDetail result = mapper.readValue(
//                    new URL(serverURL + "/orderdetails/id/10248"),
//                    OrderDetail.class);
//            Assertions.assertEquals("0", result.getDiscount());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    //______________________________________________________________________________PATCH TESTS____________
//
//    @Test
//    @DisplayName("Patch test")
//    void patchTest() {
//        var values = sendBody();
//
//        try {
//            String json = mapper.writeValueAsString(values);
//            orderDetailsRepository.save(mapper.readValue(json, OrderDetail.class));
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        values.replace("discount", "24");
//        System.out.println(values);
//
//        try {
//
//            String requestBody = mapper.writeValueAsString(values);
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(serverURL + "/orderdetails/update"))
//                    .header("Content-Type", "application/json")
//                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .build();
//            client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            OrderDetail orderDetail = orderDetailsRepository.findById("99999").get();
//            Assertions.assertEquals("24", orderDetail.getDiscount());
//
//        } catch (RuntimeException | InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    //_____________________________________________________________________________POST TESTS______________
//    @Test
//    @DisplayName("Add Order Details")
//    void addOrderDetails() {
//        if (orderDetailsRepository.existsById("99999")) {
//            orderDetailsRepository.deleteById("99999");
//        }
//
//        //______________________________________BODY MAKER_________________
//        var values = sendBody();
//
//        try {
//            String requestBody = mapper.writeValueAsString(values);
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(serverURL + "/orderdetails/new")) //CHANGE THE LOCATION TO SEND BODY TO
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .build();
//
//            client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        } catch (InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//        }
//        //____________________________________END OF BODY MAKER___________________________
//        Assertions.assertNotEquals(null, orderDetailsRepository.findById("99999").get());
//        orderDetailsRepository.deleteById("99999");
//    }
//
//    //________________________________________________________________________________PUT TEST____________________
//    @Test
//    @DisplayName("Update Order Details")
//    void updateOrderDetails() {
//        if (orderDetailsRepository.existsById("99999")) {
//            orderDetailsRepository.deleteById("99999");
//        }
//
//        try {
//            String json = mapper.writeValueAsString(sendBody());
//            orderDetailsRepository.save(mapper.readValue(json, OrderDetail.class));
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        Assertions.assertTrue(orderDetailsRepository.findById("99999").isPresent());
//
//        var values = new HashMap<String, String>() {{
//            put("id", "99999");
//            put("unitPrice", "103");
//            put("quantity", "104");
//            put("discount", "105");
//        }};
//
//        try{
//            String requestBody = mapper.writeValueAsString(values);
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(serverURL + "/orderdetails/update"))
//                    .header("Content-Type", "application/json") // FIXME this was missing
//                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .build();
//            client.send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        OrderDetail orderDetail = orderDetailsRepository.findById("99999").get();
//        Assertions.assertEquals("104", orderDetail.getQuantity());
//
//        orderDetailsRepository.deleteById("99999");
//    }
//
//    // _________________________________________________________________________________DELETE TESTS_________
//    @Test
//    @DisplayName("Delete Customer Check")
//    void deleteOrderDetailsCheck(){
//        if(!orderDetailsRepository.existsById("99999")){
//            try {
//                String json = mapper.writeValueAsString(sendBody());
//                orderDetailsRepository.save(mapper.readValue(json, OrderDetail.class));
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        try{
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(serverURL + "/orderdetails/delete/99999")).DELETE().build();
//
//            Assertions.assertTrue(orderDetailsRepository.findById("99999").isPresent());
//            client.send(request, HttpResponse.BodyHandlers.ofString());
//            Assertions.assertTrue(orderDetailsRepository.findById("99999").isEmpty());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public HashMap<String, String> sendBody() {
//        var values = new HashMap<String, String>() {{
//            put("id", "99999");
//            put("unitPrice", "103");
//            put("quantity", "104");
//            put("discount", "105");
//        }};
//        return values;
//    }
//}
