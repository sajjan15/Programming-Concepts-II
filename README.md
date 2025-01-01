# Human Resources Management System

## Project Overview

This project implements a comprehensive model of a Human Resources Management System tailored for a tiny college. The system includes functionalities to manage departments, teachers (both part-time and full-time), staff, and payroll computation. It integrates key programming concepts such as Object-Oriented Programming (OOP), graphical user interface (GUI) design, file handling, and unit testing. 

The project demonstrates robust design principles and practical application of advanced programming techniques, providing a complete solution for managing HR operations.

## Project Core Functionalities

1. **Department Management**:
   - Add, update, and manage departmental information.

2. **Teacher and Staff Management**:
   - Handle data for part-time and full-time teachers.
   - Manage staff with duty and workload assignments.

3. **Payroll Computation**:
   - Calculate salaries based on job type, workload, and additional criteria.
   - Incorporates an interface `PayRoll` with the `ComputePayRoll()` method.

4. **File Handling**:
   - Store and retrieve department, staff, and teacher data for persistence.

5. **GUI Features**:
   - User-friendly graphical interface for data input and output.

6. **Exception Handling**:
   - Manage edge cases and provide user-friendly error handling.

7. **Unit Testing**:
   - Comprehensive test suite using JUnit to ensure the correctness of methods.

## Technologies Used

- **Programming Language**: Java
- **Testing Framework**: JUnit
- **Tools**: IntelliJ IDEA
- **Other**: JavaFX for GUI, File I/O libraries for data persistence

## Project Structure

The project is structured into three main parts:

1. **Analysis and Design Document**:
   - Includes pseudocode and UML Class Diagrams for system design.

2. **Project Code**:
   - Full implementation of HR management features using Java.

3. **Test Suite**:
   - JUnit tests to verify method functionalities.

## Database Contents

Data is managed using file-based storage, with structures for:

1. **Departments**:
   - Names, IDs, and associated details.

2. **Teachers**:
   - Information including name, degree, specialty, workload, and salary.

3. **Staff**:
   - Details such as duty assignments, workload, and salaries.

4. **Payroll Records**:
   - Computed salary data for teachers and staff.

## Implementation Details

- **Abstract Class Person**: Contains shared fields and an abstract method.
- **Concrete Classes**: `Teacher` and `Staff` extend `Person` with unique attributes.
- **PayRoll Interface**: Provides a method `ComputePayRoll()` for salary computation.
- **GUI Design**: Facilitates intuitive interaction with data.
- **File Handling**: Enables persistent storage of department, teacher, and staff data.
- **Exception Handling**: Ensures robust error management.
- **Testing**: Includes a JUnit Test class to verify all controller methods.

## Real-Life Uses

1. **Educational Institutions**:
   - Manage HR operations for colleges and schools.
   
2. **Payroll Management Systems**:
   - Automate salary calculations for employees based on workload.

3. **Data-Driven Applications**:
   - File-based data handling provides cost-effective solutions for small organizations.

## Design Requirements

- Clear and precise GUI for user interaction.
- Comprehensive documentation using JavaDoc.
- Modular design for maintainability and scalability.
- All unit tests pass successfully to validate functionality.

## Contributor

- **Sajjan Gautam**

This README merges detailed implementation insights with structural clarity, providing a comprehensive overview of the project and its features.
