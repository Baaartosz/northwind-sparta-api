# Northwind-sparta-api
## A mini-project to practice development of API's
#### contributors

Jeffrey Champion - Scrum master: [JChampion42](https://github.com/Jchampion42) 

Bartosz Perczynski - git guru : [Baaartosz](https://github.com/Baaartosz)

David Carew : [0V3RL0AD](https://github.com/0V3RL0AD)

Omar Tehami : [OTDZ](https://github.com/OTDZ)

Toby Gascoigne : [tobygascoigne](https://github.com/tobygascoigne)

## Task

To create an API to interact with 5 tables from the northwind, using all CRUD methods
 * POST
 * PUT
 * PATCH
 * DELETE
 * GET

## The database 

![nortwind](https://blog.sqlauthority.com/wp-content/uploads/2007/05/Northwind_diagram-500x371.jpg)

### tables selected

We elected to used 5 tables that appear core to the database to create api's for these are:
 * customers
 * employees
 * orders
 * order details
 * products

## Task management

When approaching this task, we had some experience dabbling with API's so found that for most tables
the CRUD operations to perform, and the code associated with them 
are near copies over different tables.
Bearing this in mind, the task was split into three sprints

--------------------
### Sprint 1 - Customer Controller

After establishing user stories, setting up the basic API and connecting to git, we utilised pair programming.
All members of the group worked on one client such that we could implement all methods into the customer class.
These were all smoothly created bar one.

#### 1.1 The first blocker
Bart, who had been working on the DELETE function found that the program would not allow a deletion of a customer.
This problem was resolved by writing the mapping for customer to all the orders they relate to. This cleared our blocker.

-----------------
### Sprint 2 - Creating a test framework

Having created an example of what an API is likely to look like we now knew exactly what tests are likely to be created.
Once again utilising pair programming, the team collaborated on the test file. The get methods were easy to execute as they simply
required a HTML link. But...
#### 2.1 How can I send a body to my POST request???

This was our second blocker. It extended beyond POST to PATCH PUT and DELETE. Without the knowledge to create
a body to send to the API we had no way to test that the functions worked. Luckily we were able to consult with our
trainer. Through collaboration, we found the ability to create a HTTPClient and HTTPBuilder, using a string of JSON code.
With this format we were able to create an object relating to any data in a table. Because of this, all methods were successfuly tested

---------------
### Sprint 3 - Transition to other tables

The final task, and final sprint having spend only one day up to this point.

The goal of this task as to replicate the methods and implementation of the customer controller to apply to the other tables.
We did so by splitting onto separate git branches for each table. On these branches a new class was made for the controller, repository and tests.
These classes were then populated using all the previous methods created within the customer variant. 
After cloning, the classes were altered, Customer would become Order, email address may become a shipping address. The core of the CRUD code however, did not need change.

Converting the code to suit the other tables was a simple task, and it worked well apart from one issue

#### 3.1 Composite key errors I.E. where are my beans?

One key Hibernate function used throughout the program is "FindById()" which most of the time caused no issue when looking at the entity.
However, OrderDetails has a primary key made of two parts an orderID and a product ID. This meant that unlike other tables that had a primitive value
there was an object called "OrderDetailID id" this object itself was not happy to be passed into a FindById, probably because it had two parts it could look for.
No matter what we tried we could not get the keys to return something useful, ultimately due to time constraints we have had to comment out two tables
as they are both faced with this issue.

-------
### Outcome

The program has 3 Fully functional tables, customer, employee and orders, while products and order details are created, but are held back by these keys.



## Requirements to run

For this program to run, you will need MySQL and the northwind database to be created.

Within the program, navigate to src/main/resources/application.properties

your properties should be set up with the details below, where username and password should be for your own databases

```ini
server.port=<serverport>
spring.datasource.url=jdbc:mysql://localhost:3306/northwind
spring.datasource.username=<sql_username>
spring.datasource.password=<sql_password>
spring.jackson.serialization.fail-on-empty-beans=false
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```
