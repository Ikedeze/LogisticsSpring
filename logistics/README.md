# Logistics & Shipment Tracking API

A secure, production-ready Spring Boot backend application designed to handle shipment tracking, client data persistence, and real-time custom status aggregations using MongoDB Atlas.

## 🚀 Features
* **Cloud Database Persistence:** Seamlessly switches between local MongoDB and live MongoDB Atlas environments.
* **Custom Database Aggregations:** Uses high-performance aggregation pipelines to calculate shipment statistics dynamically by status.
* **Robust Spring Security:** Implements stateless endpoint protections using HTTP Basic Auth, password hashing via `BCryptPasswordEncoder`, and dynamic user registration mappings.
* **Interactive Web Documentation:** Fully integrated with Swagger UI (OpenAPI 3) for quick browser-based API execution and testing.

## 🛠️ Tech Stack
* **Backend Framework:** Java 17, Spring Boot 3.x, Spring Security
* **Database:** MongoDB Atlas (Cloud)
* **API Documentation:** Springdoc OpenAPI / Swagger UI

## 📋 API Architecture & Endpoints

| HTTP Method | Endpoint | Access Level | Description |
| :--- | :--- | :--- | :--- |
| **GET** | `/swagger-ui.html` | Public | Opens the visual API dashboard |
| **GET** | `/shipments/{trackingNumber}` | Public | Fetches status details for a package |
| **GET** | `/shipments/stats` | Authenticated | Computes aggregation counts for all statuses |
| **POST** | `/shipments` | Authenticated | Creates a new shipment document |

## 🛠️ How to Run Locally

1. Clone this repository:
   ```bash
   git clone [https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git](https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git)