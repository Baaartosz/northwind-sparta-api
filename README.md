# Northwind-sparta-api
## A mini-project to practice development of API's
#### contributors
Jeffrey Champion - Scrum maste
[JChampion42](https://github.com/Jchampion42) 
Bartosz Perczynski - git guru
[Baaartosz](https://github.com/Baaartosz)
David Carew
[0V3RL0AD](https://github.com/0V3RL0AD)
Omar Tehami
[OTDZ](https://github.com/OTDZ)
Toby Gascoigne
[tobygascoigne](https://github.com/tobygascoigne)

## Task
To create an API to interact with 5 tables from the northwind, using all CRUD methods
 * POST
 * PUT
 * PATCH
 * DELETE
 * GET

## The database 

![nortwind](https://blog.sqlauthority.com/wp-content/uploads/2007/05/Northwind_diagram-500x371.jpg)



application.properties
```ini
server.port=<serverport>
spring.datasource.url=jdbc:mysql://localhost:3306/northwind
spring.datasource.username=<sql_username>
spring.datasource.password=<sql_password>
spring.jackson.serialization.fail-on-empty-beans=false
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```
