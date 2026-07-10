# 🚚 Logistics API Backend

A RESTful Logistics Management API built with **Spring Boot**, **Java 17**, and **MongoDB**. This application provides shipment management, tracking, searching, and routing operations through a clean REST API with interactive Swagger documentation.

---

## 🚀 Live Demo & API Documentation

The application is deployed on **Render** and connected to a **MongoDB Atlas** cloud database.

**🌐 Live Swagger UI:**
https://logisticsspring.onrender.com/swagger-ui/index.html

---

## 🛠️ Tech Stack

* **Language:** Java 17
* **Framework:** Spring Boot
* **Database:** MongoDB (Local or MongoDB Atlas)
* **Data Access:** Spring Data MongoDB
* **API Documentation:** Springdoc OpenAPI (Swagger UI)
* **Build Tool:** Maven

---

# 📦 Features

* Create shipments
* View all shipments
* Update shipment information
* Delete shipments
* Search shipments
* Shipment tracking
* RESTful API design
* Interactive Swagger documentation
* MongoDB Atlas cloud integration
* Environment variable configuration for secure credentials

---

# 💻 Local Setup

## Prerequisites

Before running the project, ensure you have:

* Java Development Kit (JDK 17)
* Maven (or use the included Maven Wrapper)
* MongoDB Community Edition **or** a MongoDB Atlas account

---

## 1. Clone the Repository

```bash
git clone https://github.com/Ikedeze/LogisticsSpring.git
cd LogisticsSpring
```

---

## 2. Configure MongoDB

The application uses the environment variable:

```text
SPRING_MONGODB_URI
```

### Option A — Local MongoDB

Start your local MongoDB server and use:

```text
mongodb://localhost:27017/test
```

### Option B — MongoDB Atlas

Use your Atlas connection string:

```text
mongodb+srv://username:<your_password>@cluster0.xxxxx.mongodb.net/test?retryWrites=true&w=majority
```

> **Security Tip:** Never commit database passwords or connection strings containing credentials to GitHub. Use environment variables instead.

---

## 3. Configure Environment Variables (IntelliJ IDEA)

1. Open **Run → Edit Configurations**
2. Select your Spring Boot application
3. Locate **Environment Variables**
4. Add:

**Name**

```text
SPRING_MONGODB_URI
```

**Value**

```text
mongodb+srv://username:<your_password>@cluster0.xxxxx.mongodb.net/test?retryWrites=true&w=majority
```

5. Click **Apply**
6. Restart the application

---

# ▶️ Running the Application

Using the Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Or with Maven:

```bash
mvn spring-boot:run
```

The application starts on:

```text
http://localhost:8080
```

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 📚 API Endpoints

| Method | Endpoint          | Description             |
| ------ | ----------------- | ----------------------- |
| GET    | `/`               | Welcome endpoint        |
| GET    | `/shipments`      | Retrieve all shipments  |
| GET    | `/shipments/{id}` | Retrieve shipment by ID |
| POST   | `/shipments`      | Create a shipment       |
| PUT    | `/shipments/{id}` | Update a shipment       |
| DELETE | `/shipments/{id}` | Delete a shipment       |

> Search endpoints support case-insensitive matching using regular expressions where applicable.

---

# 📖 API Documentation

Once the application is running locally, visit:

```text
http://localhost:8080/swagger-ui/index.html
```

For the deployed version:

https://logisticsspring.onrender.com/swagger-ui/index.html

---

# 📁 Project Structure

```
src
├── controller
├── service
├── repository
├── model
├── dto
├── exception
└── config
```

---

# 👨‍💻 Author

**Udeze Ikechukwu**

GitHub: https://github.com/Ikedeze
