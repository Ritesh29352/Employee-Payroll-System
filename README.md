# Employee Payroll System

A simple Java console application for managing an Employee Payroll System, perfect for a Java Intern project. It demonstrates fundamental Object-Oriented Programming (OOP) concepts and File I/O for data persistence.

## Features
- **Object-Oriented Design**: Utilizes Abstraction, Inheritance, and Polymorphism.
- **Manage Employees**: Add Full-Time and Part-Time employees, remove employees by ID, and list all employees.
- **Salary Calculation**: Dynamic salary calculation based on employee type (fixed monthly vs. hourly rate).
- **Data Persistence**: Automatically saves and loads employee data using a CSV file (`employees.csv`).
- **Interactive CLI**: A user-friendly, scanner-based command-line interface menu.

## Project Structure
- `Employee.java`: Abstract base class.
- `FullTimeEmployee.java`: Inherits from `Employee`.
- `PartTimeEmployee.java`: Inherits from `Employee`.
- `PayrollSystem.java`: Manages the collection of employees.
- `FileUtil.java`: Utility class for reading from and writing to a CSV file.
- `Main.java`: The entry point featuring the interactive CLI menu.

## How to Compile and Run

1. Open your terminal or command prompt.
2. Navigate to the `src` directory of the project:
   ```bash
   cd src
   ```
3. Compile all the Java files:
   ```bash
   javac payroll/*.java
   ```
4. Run the interactive application:
   ```bash
   java payroll.Main
   ```
