# Online Shop Application

#### A full-stack Online Shop web application using Spring Boot 2 and Angular 7. 
This is a Single Page Appliaction with client-side rendering. It includes backend and frontend two seperate projects on different branches.
The frontend client makes API calls to the backend server when it is running.

## Features
- REST API
- JWT authentication
- Cookie based visitors' shopping cart
- Persistent customers' shopping cart
- Cart & order management
- Checkout
- Catalogue
- Order management
- Pagination
## Technology Stacks
**Backend**
  - Java 11
  - Spring Boot 2.2
  - Spring Security
  - JWT Authentication
  - Spring Data JPA
  - Hibernate
  - MySql
  - Maven

**Frontend**
  - Angular 7
  - Angular CLI
  - Bootstrap

## Database Schema

Install Mysql -> after installation -> Connect to the database-> give password which you provide at the time of installation.
Create Database with name "ecommerce". Then run queries provided in schema.sql script one by one.


## How to  Run

Start the backend server before the frontend client.  

**Backend**

  1. Install Mysql
  2. Configure datasource in `application.properties`.
  3. `cd backend`.
  4. Run `mvn install`.
  5. Run `mvn spring-boot:run`.
  6. The backend server is running on [localhost:8181]().

**Frontend**
  1. Install [Node.js and npm](https://www.npmjs.com/get-npm)
  2. `cd frontend`.
  3. Run `npm install`.
  4. Run `ng serve`
  5. The frontend client is running on [localhost:4200]().
  
Note: The backend API url is configured in `src/environments/environment.ts` of the frontend project. It is `localhost:8181/api` by default.


Modules:
1.Customer login
	- Create Customer from sign up page
2.Admin login
	- Default Admin Login
		User Name - admin@gmail.com
		Password - Admin

