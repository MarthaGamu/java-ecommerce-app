# Ecommerce Java Project

## Overview
This Java-based ecommerce application allows admins to manage products, users, orders, and categories. It uses Spring Boot for the backend and an H2 database for data storage.

## Features
- **User management**: Add, fetch, delete and update users
- **Product management**: Fetch, delete, edit, filter, and sort products
- **Category management**: Add, filter, and select specific categories
- **Order management**: View, delete, and fetch orders

## Technologies Used
- Java
- Spring Boot
- MySQL
- RESTful APIs
- React.js and CSS 

## Prerequisites
Before you begin, ensure you have the following installed:
- Java JDK
- MySQL
- Maven

## Setup Instructions
1. **Clone the repository:**
    ```bash
    git clone https://github.com/MarthaGamu/java-ecommerce-app.git
    cd ecommerce-java-project
    ```

2. **Configure the database:**
    - Create a database in MySQL or use the H2 database.
    - Update the `application.properties` file with your MySQL credentials.


3. **Access the application:**
    - Open your web browser and navigate to your local machine port number(`http://localhost:8080`).

## Endpoints
### Category
- GET: `http://localhost:8089/category/`
- POST: `http://localhost:8089/category/create`
- POST: `http://localhost:8089/category/update/{categoryID}`

### Product
- GET: `http://localhost:8089/product/`
- POST: `http://localhost:8089/product/add`
- DELETE: `http://localhost:8089/product/deleteByid/{id}`
- POST: `http://localhost:8089/product/update/{productID}`
- GET: `http://localhost:8089/product/category/{categoryId}`
- GET: `http://localhost:8089/product/category/{categoryId}/sort`

### User
- GET: `http://localhost:8089/user/{id}`
- POST: `http://localhost:8089/user/add`
- DELETE: `http://localhost:8089/user/deleteByid/{id}`
- PUT: `http://localhost:8089/user/update/{id}`

### Order
- POST: `http://localhost:8089/order/add`
- GET: `http://localhost:8089/order/user/{userId}`
- GET: `http://localhost:8089/order/{id}`
- DELETE: `http://localhost:8089/order/deleteById/{id}`
- PUT: `http://localhost:8089/order/update/{id}`

## Contact
For any inquiries, please contact [marthagmandizvidza60@gmail.com](mailto:marthagmandizvidza60@gmail.com).
