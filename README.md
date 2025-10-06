# InventaryManagementSystem
A backend-heavy RESTful API built using **Spring Boot** to manage products in a warehouse.  
It supports CRUD operations on products and inventory stock management.

##  Features
- Full CRUD for Products
- Increase / Decrease stock quantity
- Prevents stock from going below zero
- Proper error handling with meaningful HTTP responses

  ## **Bonus Features **
- Added a low_stock_threshold field to products and an endpoint to list all products currently below this threshold

- ## Technologies used
- Programming Language - Java 17
- Framework -springboot 3+
- Database - MySQL
- ORM Tool - Hibernate 

  ## ** Application Creation steps **
   @ In Spring Initializr selected following -
  project - Maven, language -Java,springboot version -3.5.6 ,Group -com.inventarymanagement,Java	17 or 21, Packaging-Jar.
  
  # **  added following Dependencies
  @ Spring Web 
  @Spring Data JPA
  @MySQL Driver
  @Lombok
  - Downloaded zip file and extracted it into Spring Tool Suite.
  - Created  entity, repository, service, and controller packages. and Implement CRUD operations for your API.
 
## Project Setup
1. Go to
2. Click the green “Code” button.
3. Select “Download ZIP”.
4. Extract the ZIP file to a folder on your computer.
5. Make sure STS(4.30.0) or Eclipse IDE for Enterprise Java Developers is installed<I have used sts(4.30.0.)
6. Import project-
   - Click on Import
   - Choose Existing Maven Projects
   - Click Next.
   - In the “Root Directory,” click Browse and select the folder where you extracted your project.
   - Eclipse will detect your pom.xml file automatically.
   - Click Finish.
   -  If you don’t see “Maven Projects,” you may need to install the Maven plugin for Eclipse.
  -Click on Maven and update project
   - Click on RunAs and select "Maven Build" and write "Clean Compile" as Goals as well select "Maven Clean".
   - At the end select RunAs SpringBootApp.
   - Verify It’s Running-
                         Once started, you should see: Tomcat started on port 8080 and Started InventoryManagementApplication now we can access services.
  
## To Test API
Project API Endpoint  "http://localhost:8080/product"
@ Following api endpoints :
1.Save Product - http://localhost:8080/product/register  
method=POST
2.Get all  Products - http://localhost:8080/product/get  
method=GET
3.Update Products  by id - http://localhost:8080/product/update/{id}
method=PUT
4.Delete Product by id - http://localhost:8080/product/del/{id}
method=DELETE
5. IncreaseProduct - http://localhost:8080/product/{id}/increase 
method=POST  
6. DecreaseProduct - http://localhost:8080/product/{id}/decrease 
method=POST
7.Get LowStocks - http://localhost:8080/product/products/lowstock
methos=GET
8.Get Products  by id - http://localhost:8080/product/{id}
methos=GET
  
  
