# 📦 Smart Inventory & P2P Dashboard
### *Real-time SAP Material Management Extension*

This enterprise-grade application simulates a modern **Procure-to-Pay (P2P)** lifecycle and smart inventory management system. It is designed to function as an extension to standard SAP ERP systems, providing real-time tracking, critical stock alerts, and automated purchase requisition generation to prevent supply chain bottlenecks.

---

## 🏗️ System Architecture
The project utilizes a decoupled, microservice-ready architecture to ensure scalability and high availability.

* **Frontend:** React.js (Vite), Axios for API communication, Responsive CSS Grid, and dynamic state management.
* **Backend:** Java 25, Spring Boot 4.x, Spring Web, Spring Data JPA.
* **Data Layer:** H2 In-Memory Database for zero-setup portability and iterative development.
* **API Protocol:** RESTful JSON Endpoints with CORS-enabled proxying for cloud environments.

---

## ✨ Key Features

* **Real-Time Inventory Monitoring:** Automatically fetches material stock levels from the backend and renders them in a high-readability dashboard.
* **Smart Threshold Logic:** The system dynamically identifies "Critical Stock" items (e.g., Sensor Arrays, Power Units) using a comparative algorithm against pre-defined safety thresholds.
* **Automated P2P Workflow:** Features a 1-click trigger to generate a `PENDING_APPROVAL` Purchase Requisition, simulating real-world SAP MM (Materials Management) workflows.
* **Dark-Mode Enterprise UI:** A premium, scroll-driven UI designed for high-density information environments.

---

## 📂 Project Structure

```text
2306048_capstone-supply-chain-p2p/
├── p2p-frontend/           # React Application (Vite)
│   ├── src/
│   │   ├── App.jsx         # Dashboard Logic & API Calls
│   │   └── App.css         # Enterprise Styling
│   └── vite.config.js      # Proxy Configuration
├── src/                    # Spring Boot Application
│   ├── main/java/.../
│   │   ├── model/          # Entity Definitions (Material, Requisition)
│   │   ├── repository/     # JPA Data Access Layers
│   │   └── controller/     # REST API Endpoints
│   └── main/resources/
│       ├── data.sql        # Automated Test Data Injection
│       └── application.properties
└── pom.xml                 # Maven Dependency Management

```


## 🚀 Installation & Setup

### 1. Prerequisites
* **Java 21** or higher
* **Node.js 18** or higher
* **Maven 3.9+**

### 2. Run the Backend (Spring Boot)
From the root directory, execute:
```
mvn spring-boot:run
```

### 3. Run the Frontend (React)
Open a new terminal, navigate to the frontend folder, and start the development server:
```
cd p2p-frontend
npm install
npm run dev
```
## ☁️ Cloud Deployment
This project is configured for SAP BTP Cloud Foundry.
Deployment Command:
```
mvn clean package -DskipTests
cf push
```
Live Backend URL: https://sahil-p2p-backend-mediating-panda-io.cfapps.ap21.hana.ondemand.com/api/inventory/materials

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/inventory/materials` | Fetch all current material stock levels. |
| **GET** | `/api/inventory/low-stock` | Retrieve items currently below the safety threshold. |
| **POST** | `/api/inventory/requisition` | Generate a new Purchase Requisition (P2P Flow). |




