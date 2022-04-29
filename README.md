# BAE_WebApplication
QA Practical Project - Web Application

This codebase was created to demonstrate a full-stack application built with Spring boot + MySQL including CRUD operations.

The aim of this project was to have a CRUD-based web application, 
with utilisation of supporting tools, methodologies, and technologies, 
that encapsulates all fundamental and practical modules covered during training with QA.

    Spring JPA and MySQL for data persistence
   
To build and run the sample from a fresh clone of this repo:

Configure MySQL

    Create a database in MySQL.
    Update the application.properties file in the src/main/resources folder with the URL, username and password for MySQL. 


The application requires Java 11 JDK


It uses a H2 in-memory database sqlite database 
(for easy local test without losing test data after every restart), can be changed easily in the application.properties for any other database.


    mvnw package
    Open a web browser to http://localhost:8080
