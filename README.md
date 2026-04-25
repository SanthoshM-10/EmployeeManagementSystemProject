# Employee Management System

## Project Overview
The Employee Management System is a console-based application developed using Java, JDBC, and MySQL.  
It is designed to manage employee records efficiently by replacing manual record handling, which is time-consuming and error-prone.

---

## Features
- Add new employee records
- View all employee details
- Update employee information
- Delete employee records
- Search employee by ID

---

## Technologies Used
- Java (Core Java)
- JDBC (Java Database Connectivity)
- MySQL Database

---

## Project Structure
- **MainApp.java** → Handles user interaction (console input/output)
- **Employee.java** → Model class representing employee data
- **EmployeeDAO.java** → Contains database operations (CRUD)
- **DBConnection.java** → Handles database connection using JDBC

---

## How It Works
1. User interacts with the system through a console menu.
2. Based on user input, the application performs operations like add, update, delete, or view employees.
3. The request is passed to the DAO layer.
4. JDBC is used to connect to the MySQL database.
5. SQL queries are executed to store or retrieve data.
6. Results are displayed back to the user.

---

## Workflow
User Input → Java Application → DAO Layer → JDBC → MySQL Database → Result

---

## Database Schema

```sql
CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary DOUBLE,
    email VARCHAR(100)
);
