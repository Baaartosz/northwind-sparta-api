package com.sparta.group3.northwindtask.northwindtask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.group3.northwindtask.northwindtask.entities.Employee;
import com.sparta.group3.northwindtask.northwindtask.repos.EmployeeRepository;
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
public class EmployeeControllerTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ObjectMapper mapper = new ObjectMapper();

    String serverURL = "http://localhost";

    //_________________________________________________________________________GET TESTS________
    @Test
    @DisplayName("Get Employee by ID")
    void getById() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/id/1"),
                    Employee.class);
            Assertions.assertEquals("1", result.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee Last Name")
    void getCompanyName() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/lastname/Daviolo"),
                    Employee.class);
            Assertions.assertEquals("Daviolo", result.getLastName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee First Name")
    void getContactName() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/firstname/Nancy"),
                    Employee.class);
            Assertions.assertEquals("Nancy", result.getFirstName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee Title Of Courtesy")
    void getContactTitle() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/TitleOfCourtesy/Sales Representative"),
                    Employee.class);
            Assertions.assertEquals("Sales Representative", result.getTitle());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee address")
    void getContactAddress() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/address/507 - 20th Ave. E.Apt. 2A"),
                    Employee.class);
            Assertions.assertEquals("507 - 20th Ave. E.Apt. 2A", result.getAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee city")
    void getContactCity() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/city/Seattle"),
                    Employee.class);
            Assertions.assertEquals("Seattle", result.getCity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee Region")
    void getContactRegion() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/region/WA"),
                    Employee.class);
            Assertions.assertEquals("WA", result.getRegion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee post code")
    void getContactPostCode() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/postalCode/98122"),
                    Employee.class);
            Assertions.assertEquals("98122", result.getPostalCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee country")
    void getContactCountry() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/country/USA"),
                    Employee.class);
            Assertions.assertEquals("USA", result.getCountry());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee home phone")
    void getContactPhone() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/homePhone/(206) 555-9857"),
                    Employee.class);
            Assertions.assertEquals("(206) 555-9857", result.getHomePhone());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee Birth Date")
    void getBirthDate() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/BirthDate/1948-12-08 00:00:00"),
                    Employee.class);
            Assertions.assertEquals("1948-12-08 00:00:00", result.getBirthDate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Get Employee Hire Date")
    void getHireDate() {
        try {
            Employee result = mapper.readValue(
                    new URL(serverURL + "/Employees/HireDate/1992-05-01 00:00:00"),
                    Employee.class);
            Assertions.assertEquals("1992-05-01 00:00:00", result.getHireDate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //______________________________________________________________________________PATCH TESTS____________

//    @Test
//    @DisplayName("Patch test")
//    void patchTest() {
//        var values = sendBody();
//
//        try {
//            String json = mapper.writeValueAsString(values);
//            EmployeeRepository.save(mapper.readValue(json, Employee.class));
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        values.replace("country", "Iceland");
//        System.out.println(values.toString());
//
//        try {
//
//            String requestBody = mapper.writeValueAsString(values);
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(serverURL + "/Employees/update"))
//                    .header("Content-Type", "application/json") // FIXME this was missing
//                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .build();
//            client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            Employee Employee = EmployeeRepository.findById("AAAAA").get();
//            Assertions.assertEquals("Iceland", Employee.getCountry());
//
//        } catch (RuntimeException | InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //_____________________________________________________________________________POST TESTS______________
//    @Test
//    @DisplayName("Add Employee")
//    void addEmployee() {
//        if (employeeRepository.existsByLastName("Frankenversand")) {
//            employeeRepository.deleteByLastName("Frankenversand");
//        }
//
//        //______________________________________BODY MAKER_________________
//        var values = sendBody();
//        /*var values = new HashMap<String, String>() {{
//            put("id", "AAAAA");
//            put("companyName", "Frankenversand");
//            put("contactName", "Peter Franken");
//            put("contactTitle", "Marketing Manager");
//            put("address", "Berliner Platz 43");
//            put("city", "Mnchen");
//            put("region", null);
//            put("postalCode", "80805");
//            put("country", "Germany");
//            put("phone", "089-0877310");
//            put("fax", "089-0877451");
//        }};*/
//
//        try {
//            String requestBody = mapper.writeValueAsString(sendBody());
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(serverURL + "/Employees/new")) //CHANGE THE LOCATION TO SEND BODY TO
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
//
////        try {
////            Employee result = mapper.readValue(
////                    new URL("http://localhost/Employees/id/AAAAA"),
////                    Employee.class);
////            Assertions.assertNotEquals(null, result);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        } // VVVVVVVVVVVVV
//        Assertions.assertNotEquals(null, employeeRepository.findByLastName("Frankenversand").get());
//        employeeRepository.deleteByLastName("Frankenversand");
//    }

    //________________________________________________________________________________PUT TEST____________________
//    @Test
//    @DisplayName("Update Employee")
//    void updateEmployee() {
//        if (employeeRepository.existsById("AAAAA")) {
//            employeeRepository.deleteById("AAAAA");
//        }
////        // If AAAAA doesn't exist it should create it
//
//        try {
//            String json = mapper.writeValueAsString(sendBody());
//            employeeRepository.save(mapper.readValue(json, Employee.class));
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        Assertions.assertTrue(employeeRepository.findById("AAAAA").isPresent());
//
//        var values = new HashMap<String, String>() {{
//            put("id", "AAAAA");
//            put("companyName", "A");
//            put("contactName", "A");
//            put("contactTitle", "Marketing Manager");
//            put("address", "Berliner Platz 43");
//            put("city", "Mnchen");
//            put("region", null);
//            put("postalCode", "80805");
//            put("country", "Germany");
//            put("phone", "089-0877310");
//            put("fax", "089-0877451");
//        }};
//
//        try{
//            String requestBody = mapper.writeValueAsString(values);
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(serverURL + "/Employees/update"))
//                    .header("Content-Type", "application/json") // FIXME this was missing
//                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .build();
//            client.send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        Employee Employee = employeeRepository.findById("AAAAA").get();
//        Assertions.assertEquals("A", Employee.getCompanyName());
//
//        employeeRepository.deleteById("AAAAA");
//    }

    // _________________________________________________________________________________DELETE TESTS_________
    @Test
    @DisplayName("Delete Employee Check")
    void deleteEmployeeCheck(){
        if(!employeeRepository.existsByLastName("Frankenversand")){
            try {
                String json = mapper.writeValueAsString(sendBody());
                employeeRepository.save(mapper.readValue(json, Employee.class));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost/Employees/delete/DANK")).DELETE().build();

            Assertions.assertTrue(employeeRepository.existsByLastName("Frankenversand"));
            client.send(request, HttpResponse.BodyHandlers.ofString());
            Assertions.assertTrue(employeeRepository.existsByLastName("Frankenversand"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, String> sendBody() {
        var values = new HashMap<String, String>() {{
            put("lastName", "Frankenversand");
            put("firstName", "Frank");
            put("title", "Marketing Manager");
            put("titleOfCourtesy", "Mr.");
            put("birthDate", "1960-05-29 00:00:00");
            put("hireDate", "1994-01-02 00:00:00");
            put("address", "4726 - 11th Ave. N.E.");
            put("city", "Seattle");
            put("postalCode", "98122");
            put("country", "089-0877451");
            put("region", "WA");
            put("homePhone", "(206) 555-9857");
            put("extension", "USA");
            put("photo", "photodata");
            put("notes", "Education includes a BA in psychology from Colorado State University in 1970.  She also completed \"The Art of the Cold Call.\"  Nancy is a member of Toastmasters International.");
            put("reportsTo", "2");
            put("photoPath", "http://accweb/emmployees/davolio.bmp51");
            put("salary", String.valueOf(2510.45d));
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
