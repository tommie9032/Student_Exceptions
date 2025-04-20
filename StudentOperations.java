// StudentOperations.java - Class for performing student operations

import java.util.*;

// Class to manage student-related operations
class StudentOperations {
    // List to store Student objects
    private ArrayList<Student> students;

    // Constructor to initialize the student list
    public StudentOperations() {
        this.students = new ArrayList<>();
    }

    // Method to add a new student
    public void addStudent(Student student) {
        // Check if a student with the same PRN already exists
        if (searchByPRN(student.getPRN()) != null) {
            throw new IllegalArgumentException("Student with this PRN already exists.");
        }
        // Add student to the list
        students.add(student);
        System.out.println("Student Added Successfully.");
    }

    // Method to display all students
    public void displayStudents() {
        // If no students, show appropriate message
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            // Loop through and display each student
            for (Student student : students) {
                try {
                    student.display(); // Call display method of Student class
                } catch (Exception e) {
                    // Handle any errors during display
                    System.out.println("Error displaying student: " + e.getMessage());
                }
            }
        }
    }

    // Method to search for a student by PRN
    public Student searchByPRN(String prn) {
        // Validate PRN: must be 11-digit numeric string
        if (prn == null || !prn.matches("\\d{11}")) {
            throw new IllegalArgumentException("Invalid PRN format. Must be 11 digits.");
        }

        // Search through the list for a matching PRN
        for (Student student : students) {
            if (student.getPRN().equals(prn)) {
                return student; // Return the found student
            }
        }
        return null; // Return null if no match found
    }

    // Method to search for a student by name (case insensitive)
    public List<Student> searchByName(String name) {
    // Validate name input
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}

		List<Student> matchedStudents = new ArrayList<>();

		for (Student student : students) {
			if (student.getName().equalsIgnoreCase(name)) {
				matchedStudents.add(student);
			}
		}

		return matchedStudents; // Could be empty if no match found
	}


    // Method to delete a student by PRN
    public boolean deleteStudent(String prn) {
        // Validate PRN input
        if (prn == null || !prn.matches("\\d{11}")) {
            throw new IllegalArgumentException("Invalid PRN format. Must be 11 digits.");
        }

        // Use iterator to safely remove while iterating
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getPRN().equals(prn)) {
                iterator.remove(); // Remove student
                return true; // Indicate successful deletion
            }
        }
        return false; // No match found, deletion failed
    }
}
