// Name: Sahil Awatramani
// PRN: 23070126112
// Batch: B2

import java.util.*;

// Custom exception for invalid PRN
class InvalidPRNException extends Exception {
    public InvalidPRNException(String message) {
        super(message);
    }
}

// Custom exception for invalid CGPA
class InvalidCGPAException extends Exception {
    public InvalidCGPAException(String message) {
        super(message);
    }
}

// Custom exception for duplicate PRN entry
class DuplicatePRNException extends Exception {
    public DuplicatePRNException(String message) {
        super(message);
    }
}

// Custom exception for when a student is not found
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        // Scanner object to take user input
        Scanner scan = new Scanner(System.in);

        // Object of StudentOperations to perform various actions
        StudentOperations operations = new StudentOperations();

        // Menu-driven program that keeps running until user exits
        while (true) {
            try {
                // Displaying the menu
                System.out.println("\nMenu:");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search by PRN");
                System.out.println("4. Search by Name");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = scan.nextInt(); // Reading user choice
                scan.nextLine(); // Clearing the buffer

                // Performing action based on user's choice
                switch (choice) {
                    case 1:
                        // Taking student details as input
                        System.out.print("Enter Name: ");
                        String name = scan.nextLine();

                        System.out.print("Enter PRN (11 digits): ");
                        String prn = scan.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = scan.nextLine();

                        System.out.print("Enter Batch: ");
                        String batch = scan.nextLine();

                        System.out.print("Enter CGPA: ");
                        float cgpa = scan.nextFloat();
                        scan.nextLine(); // Clear buffer

                        // Validating PRN format
                        if (!prn.matches("\\d{11}")) {
                            throw new InvalidPRNException("PRN must be 11 digits.");
                        }

                        // Validating CGPA range
                        if (cgpa < 0.0 || cgpa > 10.0) {
                            throw new InvalidCGPAException("CGPA must be between 0.0 and 10.0.");
                        }

                        // Checking for duplicate PRN
                        if (operations.searchByPRN(prn) != null) {
                            throw new DuplicatePRNException("Student with this PRN already exists.");
                        }

                        // Creating and adding new student
                        Student newStudent = new Student(name, prn, dept, batch, cgpa);
                        operations.addStudent(newStudent);
                        break;

                    case 2:
                        // Displaying all students
                        operations.displayStudents();
                        break;

                    case 3:
                        // Searching student by PRN
                        System.out.print("Enter PRN to search: ");
                        String searchPrn = scan.nextLine();
                        Student foundPrn = operations.searchByPRN(searchPrn);

                        if (foundPrn != null)
                            foundPrn.display(); // Display student if found
                        else
                            throw new StudentNotFoundException("Student with PRN " + searchPrn + " not found.");
                        break;

                    case 4:
                        // Searching students by Name
                        System.out.print("Enter Name to search: ");
                        String searchName = scan.nextLine();
                        List<Student> foundList = operations.searchByName(searchName);

                        if (!foundList.isEmpty()) {
                            for (Student s : foundList) {
                                s.display(); // Display each matching student
                            }
                        } else {
                            throw new StudentNotFoundException("No students with name " + searchName + " found.");
                        }
                        break;

                    case 5:
                        // Deleting a student by PRN
                        System.out.print("Enter PRN to delete: ");
                        String delPrn = scan.nextLine();

                        if (operations.deleteStudent(delPrn)) {
                            System.out.println("Student deleted successfully.");
                        } else {
                            throw new StudentNotFoundException("Student with PRN " + delPrn + " not found.");
                        }
                        break;

                    case 6:
                        // Exit the program
                        System.out.println("Exiting...");
                        scan.close();
                        return;

                    default:
                        // Handling invalid menu choices
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (InputMismatchException e) {
                // Handle wrong input type (e.g., letters when expecting numbers)
                System.out.println("Invalid input type. Please enter numeric values where required.");
                scan.nextLine(); // Clear buffer

            } catch (InvalidPRNException | InvalidCGPAException | DuplicatePRNException | StudentNotFoundException | IllegalArgumentException e) {
                // Handle all custom and standard exceptions
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                // Catch any unexpected exceptions
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
