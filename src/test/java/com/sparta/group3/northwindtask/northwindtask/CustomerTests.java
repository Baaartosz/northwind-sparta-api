package com.sparta.group3.northwindtask.northwindtask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.group3.northwindtask.northwindtask.entities.Customer;
import com.sparta.group3.northwindtask.northwindtask.repos.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest()
public class CustomerTests {

    @Autowired
    private CustomerRepository customerRepository;

    private ObjectMapper mapper = new ObjectMapper();

    String serverURL = "http://localhost";

    //_________________________________________________________________________GET TESTS________
    @Test
    @DisplayName("Get customer by ID")
    void getById() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals("CHOPS", result.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer companyName")
    void getCompanyName() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals("Chop-suey Chinese", result.getCompanyName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer contactName")
    void getContactName() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals("Yang Wang", result.getContactName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer contactTitle")
    void getContactTitle() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals("Owner", result.getContactTitle());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer address")
    void getContactAddress() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals("Hauptstr. 29", result.getAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer city")
    void getContactCity() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals("Bern", result.getCity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer Region")
    void getContactRegion() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals(null, result.getRegion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer post code")
    void getContactPostCode() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals("3012", result.getPostalCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer country")
    void getContactCountry() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals("Switzerland", result.getCountry());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer phone")
    void getContactPhone() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals("0452-076545", result.getPhone());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get customer Fax")
    void getContactFax() {
        try {
            Customer result = mapper.readValue(
                    new URL(serverURL + "/customers/id/CHOPS"),
                    Customer.class);
            Assertions.assertEquals(null, result.getFax());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //______________________________________________________________________________PATCH TESTS____________

    @Test
    @DisplayName("Patch test")
    void patchTest() {
        var values = sendBody();
        try {
            String requestBody = mapper.writeValueAsString(values);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverURL + "/customers/new")) //CHANGE THE LOCATION TO SEND BODY TO
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        try {
            values.put("country", "Iceland");
            String requestBody = mapper.writeValueAsString(values);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverURL + "/customers/update"))
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
            Customer customer = customerRepository.findById("AAAAA").get();
            Assertions.assertEquals("Iceland", customer.getCountry());

        } catch (RuntimeException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    //_____________________________________________________________________________POST TESTS______________
    @Test
    @DisplayName("Add customer")
    void addCustomer() {
        if (customerRepository.existsById("AAAAA")) {
            customerRepository.deleteById("AAAAA");
        }

        //______________________________________BODY MAKER_________________
        var values = sendBody();
        /*var values = new HashMap<String, String>() {{
            put("id", "AAAAA");
            put("companyName", "Frankenversand");
            put("contactName", "Peter Franken");
            put("contactTitle", "Marketing Manager");
            put("address", "Berliner Platz 43");
            put("city", "Mnchen");
            put("region", null);
            put("postalCode", "80805");
            put("country", "Germany");
            put("phone", "089-0877310");
            put("fax", "089-0877451");
        }};*/

        try {
            String requestBody = mapper.writeValueAsString(values);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverURL + "/customers/new")) //CHANGE THE LOCATION TO SEND BODY TO
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
        Assertions.assertNotEquals(null, customerRepository.findById("AAAAA").get());
        customerRepository.deleteById("AAAAA");
    }

    //________________________________________________________________________________PUT TEST____________________
    @Test
    @DisplayName("Update customer")
    void updateCustomer() {
        if (customerRepository.existsById("AAAAA")) {
            customerRepository.deleteById("AAAAA");
        }
        // If AAAAA doesn't exist it should create it
        try {
            String requestBody = mapper.writeValueAsString(sendBody());
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverURL + "/customers/update"))
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertTrue(customerRepository.findById("AAAAA").isPresent());

        var values = new HashMap<String, String>() {{
            put("id", "AAAAA");
            put("companyName", "A");
            put("contactName", "A");
            put("contactTitle", "Marketing Manager");
            put("address", "Berliner Platz 43");
            put("city", "Mnchen");
            put("region", null);
            put("postalCode", "80805");
            put("country", "Germany");
            put("phone", "089-0877310");
            put("fax", "089-0877451");
        }};
        try{
            String requestBody = mapper.writeValueAsString(values);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(serverURL + "/customers/update"))
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        Customer customer = customerRepository.findById("AAAAA").get();
        Assertions.assertEquals("A", customer.getCompanyName());

        customerRepository.deleteById("AAAAA");
    }

    // _________________________________________________________________________________DELETE TESTS_________
    @Test
    @DisplayName("Delete Customer Check")
    void deleteCustomerCheck(){
        if(!customerRepository.existsById("DANK")){
            try {
                Customer welovefrank = mapper.readValue("{\"id\":\"DANK\",\"companyName\":\"Frankenversand\",\"contactName\":\"Peter Franken\",\"contactTitle\":\"Marketing Manager\",\"address\":\"Berliner Platz 43\",\"city\":\"Mnchen\",\"region\":null,\"postalCode\":\"80805\",\"country\":\"Russia\",\"phone\":\"089-0877310\",\"fax\":\"089-0877451\"}",Customer.class);
                customerRepository.save(welovefrank);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost/customers/delete/DANK")).DELETE().build();

            Assertions.assertTrue(customerRepository.findById("DANK").isPresent());
            client.send(request, HttpResponse.BodyHandlers.ofString());
            Assertions.assertTrue(customerRepository.findById("DANK").isEmpty());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Map sendBody() {
        var values = new HashMap<String, String>() {{
            put("id", "AAAAA");
            put("companyName", "Frankenversand");
            put("contactName", "Peter Franken");
            put("contactTitle", "Marketing Manager");
            put("address", "Berliner Platz 43");
            put("city", "Mnchen");
            put("region", null);
            put("postalCode", "80805");
            put("country", "Germany");
            put("phone", "089-0877310");
            put("fax", "089-0877451");
        }};
        return values;
    }
    /*
        try {
            String requestBody = mapper.writeValueAsString(values);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url)) //CHANGE THE URL LOCATION TO SEND BODY TO
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody)) // CHANGE FROM POST TO SUITABLE
                    .build();

            client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (JsonProcessingException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    }*/
}
