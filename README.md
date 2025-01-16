# Bursary Application System

## Overview
The Bursary Application System is designed to streamline the process of submitting and managing bursary applications. It uses a modern architecture incorporating RabbitMQ for event-driven messaging and ensures scalability, fault tolerance, and separation of concerns.

---

## Features
1. Students submit applications via a user-friendly frontend.
2. The backend validates and processes the applications.
3. RabbitMQ decouples the application submission process from data persistence.
4. A consumer saves the application data into the database.

---

## Database Design
The database consists of the application table:



### 2. **Applications Table**

| Field              | Type         | Description                               |
|--------------------|--------------|-------------------------------------------|
| id                 | BIGINT       | Primary Key                               |
| first_name         | VARCHAR(255) | Student's first name                      |
| last_name          | VARCHAR(255) | Student's last name                       |
| email              | VARCHAR(255) | Student's email                           |
| phone_number       | VARCHAR(20)  | Student's phone number                    |
| gender             | VARCHAR(255) | Student's gender                          |
| kcse_grade         | VARCHAR(255) | Student's kcse grade                      |
| school             | VARCHAR(50)  | Name of the school                        |
| programe_fees      | VARCHAR(255) | fees of the program                       |
 

---

## Application Architecture
The Bursary Application System follows a simplified microservices architecture with the following components:

### 1. **Frontend**
- **Role:**
  - Allows students to submit their applications.
  - Communicates with the backend via REST API.

### 2. **Application Submission Service**
- **Role:**
  - Receives application data from the frontend.
  - Publishes the application payload to RabbitMQ.

### 3. **RabbitMQ**
- **Role:**
  - Acts as a message broker to decouple the submission process from the database operations.
  - Ensures fault tolerance by queuing messages if the consumer is unavailable.

### 4. **Application Processing Service**
- **Role:**
  - Consumes messages from RabbitMQ.
  - saves the data into the database.

---

## Process Flow Diagram
```plaintext
1. Student submits application via frontend.
   |
   v
2. Application Submission Service receives the request and validates it.
   |
   v
3. Application payload is published to RabbitMQ.
   |
   v
4. RabbitMQ queues the application.
   |
   v
5. Application Processing Service consumes the message.
   |
   v
6. Application is validated and saved to the database.
   
   
![rabbitmq](https://github.com/user-attachments/assets/9f26170c-b750-48ca-a0a0-5fc33c2cd123)
![rabbitmq payload](https://github.com/user-attachments/assets/9fe0b85a-65df-41d9-92bb-4dd5a8012c45)
![Screenshot 2025-01-16 232640](https://github.com/user-attachments/assets/ee67497b-9d43-4381-a2fb-89c462c93612)
![Screenshot 2025-01-16 232717](https://github.com/user-attachments/assets/64cecbca-6750-454a-8622-4de114a0d929)
![Screenshot 2025-01-16 232745](https://github.com/user-attachments/assets/751a3e59-1c2c-4b2e-8a49-d83e78d2bb2e)

```
![rabbitmq](https://github.com/user-attachments/assets/ce7815be-811e-433a-9b2c-b989ac4c25ba)

---

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/bursary-app.git
   ```

2. Install dependencies:
   ```bash
   # For backend
   cd backend
   pip install -r requirements.txt
   
   # For frontend
   cd frontend
   npm install
   ```

3. Start RabbitMQ:
   ```bash
   rabbitmq-server
   ```

4. Run the services:
   - **Frontend:**
     ```bash
     npm start
     ```
   - **Backend (Application Submission Service):**
     ```bash
     python app.py
     ```
   - **Consumer (Application Processing Service):**
     ```bash
     python consumer.py
     ```

---

## Usage
1. Access the frontend via `http://localhost:3000`.
2. Submit an application form.


---

## Future Improvements
1. Introduce a Notification Service to update students about application status in real-time.
2. Add authentication and role-based access control for administrators.

---



---

## Contact
For any questions or feedback, reach out at brentjure@gmail.com.

