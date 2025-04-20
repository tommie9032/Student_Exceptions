# 🎓 Student Management System (with Custom Exceptions)

A Java-based Student Management System that enables users to perform basic CRUD operations (Create, Read, Update, Delete) on student records through a menu-driven interface. This system uses Object-Oriented Programming (OOP) principles and features comprehensive exception handling using custom exceptions.

---

## 📁 Project Structure

### Files and Classes

1. **`Student.java`**  
   Represents the `Student` class, encapsulating student data and access methods.

2. **`StudentOperations.java`**  
   Contains logic for managing student records such as adding, searching, editing, deleting, and displaying.

3. **`Main.java`**  
   The entry point of the program. Implements a console-based menu for interacting with the student system.

---

## 🧑‍🎓 Student.java

Defines the structure and behavior of a `Student` object.

### Constructor

| Method | Description |
|--------|-------------|
| `Student(String name, long prn, int age, double cgpa)` | Initializes a new Student object. |

### Getters & Setters

| Method | Description |
|--------|-------------|
| `setName(String name)` / `getName()` | Sets or retrieves the student’s name. |
| `setPrn(long prn)` / `getPrn()`       | Sets or retrieves the PRN (Permanent Registration Number). |
| `setAge(int age)` / `getAge()`       | Sets or retrieves the student’s age. |
| `setCgpa(double cgpa)` / `getCgpa()` | Sets or retrieves the student’s CGPA. |

### Utility Method

| Method | Description |
|--------|-------------|
| `display()` | Displays the details of the student. |

---

## ⚙️ StudentOperations.java

Handles core functionality for managing student data.

### Constructor

| Method | Description |
|--------|-------------|
| `StudentOperations()` | Initializes the internal `ArrayList` to store students. |

### Key Methods

| Method | Description |
|--------|-------------|
| `addStudent(Student student)` | Adds a new student to the list. |
| `displayStudents()`           | Prints all student records. |
| `searchStudent()`             | Provides options to search for a student by PRN, name, or position. |
| `searchByPrn(long prn)`       | Searches for a student by PRN. |
| `searchByName(String name)`   | Searches by name (case-insensitive). |
| `searchByPosition(int pos)`   | Finds a student by index in the list. |
| `deleteStudent()`             | Deletes a student by their PRN. |
| `editStudent()`               | Edits a student’s details using their PRN. |

---

## 🧾 Main.java

The main driver class that displays a menu and handles user interactions.

### Menu Options

| Option | Description |
|--------|-------------|
| 1 | Add a new student. |
| 2 | Display all student records. |
| 3 | Search for a student (by PRN, Name, or Position). |
| 4 | Delete a student (by PRN). |
| 5 | Edit student details (by PRN). |
| 6 | Exit the application. |

---

## 🚨 Custom Exceptions

The system uses custom exceptions to handle errors gracefully and enforce validation rules.

| Exception | Description |
|-----------|-------------|
| `InvalidNameException` | Thrown when a student name contains non-letter characters. |
| `InvalidPRNException` | Thrown when the PRN is not exactly 10 digits long. |
| `InvalidAgeException` | Thrown when the student’s age is not between 16 and 100. |
| `InvalidCGPAException` | Thrown when CGPA is not between 0 and 10. |
| `DuplicatePRNException` | Thrown if a student with the same PRN already exists. |
| `StudentNotFoundException` | Thrown when a student cannot be located using PRN or name. |
| `EmptyStudentListException` | Thrown when operations are attempted on an empty list. |
| `InvalidSearchChoiceException` | Thrown when the user selects an invalid search option. |
| `InvalidPositionException` | Thrown when an invalid index is used for accessing a student. |
| `InvalidMenuChoiceException` | Thrown on invalid main menu choices. |
| `NullStudentException` | Thrown when trying to add a null `Student` object. |
| `TooManyStudentsException` | Thrown when exceeding the student limit (e.g., more than 100 students). |
| `EditNotAllowedException` | Thrown when editing a student is not permitted. |
| `DeletionNotAllowedException` | Thrown when deletion of a student is disallowed. |
| `EmptyNameException` | Thrown when a student's name is empty or null. |
| `NegativeValueException` | Thrown when negative values are provided for PRN, age, or CGPA. |

---

## ✅ Features Summary

- Object-Oriented Design
- CRUD operations on student records
- Menu-based console interaction
- Fully validated input
- Rich exception handling using custom exception classes
