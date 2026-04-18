# Smart Inventory & P2P Dashboard
**Real-time SAP Material Management Extension**

This enterprise-grade application simulates a modern Procure-to-Pay (P2P) lifecycle and smart inventory management system. It is designed to act as an extension to standard SAP ERP systems, providing real-time tracking, critical stock alerts, and automated purchase requisition generation.

## 🏗️ System Architecture
This project utilizes a decoupled, microservice-ready architecture separating the presentation layer from the business logic and data persistence layers.
* **Frontend:** React.js (Vite), Axios for API communication, responsive CSS Grid.
* **Backend:** Java, Spring Boot, Spring Web, Spring Data JPA.
* **Database:** H2 In-Memory Database (configured for zero-setup, portable deployments).

## ✨ Key Features
* **Real-Time Dashboard:** Fetches and displays material stock levels dynamically.
* **Threshold Monitoring:** Automatically flags inventory items (e.g., Sensor Arrays, Power Supply Units) when they fall below minimum operational thresholds.
* **Automated Requisition:** 1-click trigger to generate a `PENDING_APPROVAL` Purchase Requisition payload, mimicking SAP MM standard flows.
* **CORS & Proxy Configured:** Secure communication between disparate frontend and backend cloud ports.

## 🚀 How to Run Locally

### 1. Start the Spring Boot Backend
Navigate to the root directory (`p2p-backend`) and run the Maven wrapper:
```bash
mvn spring-boot:run


2. Start the React Frontend
Open a second terminal instance, navigate to the frontend directory, and start the Vite development server:

Bash
cd p2p-frontend
npm install
npm run dev
The UI will initialize on http://localhost:5173.

Developed by: Sahil Ballav
Institution: KIIT University | 
Project Type: 6th Semester Capstone