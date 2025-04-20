// Student.java - Class representing a student

// Class to model a student with attributes like name, PRN, department, batch, and CGPA
class Student {
    // Private fields for encapsulation
    private String name;
    private String prn;
    private String dept;
    private String batch;
    private float cgpa;

    // Constructor with validation to initialize student object
    public Student(String name, String prn, String dept, String batch, float cgpa) {
        // Validate name is not null or empty
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        // Validate PRN: must be exactly 11 digits
        if (!prn.matches("\\d{11}")) {
            throw new IllegalArgumentException("PRN must be exactly 11 digits.");
        }

        // Validate department is not null or empty
        if (dept == null || dept.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }

        // Validate batch is not null or empty
        if (batch == null || batch.trim().isEmpty()) {
            throw new IllegalArgumentException("Batch cannot be empty.");
        }

        // Validate CGPA range between 0.0 to 10.0
        if (cgpa < 0.0 || cgpa > 10.0) {
            throw new IllegalArgumentException("CGPA must be between 0.0 and 10.0.");
        }

        // Assigning values if all validations are passed
        this.name = name;
        this.prn = prn;
        this.dept = dept;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name with validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    // Getter method for PRN
    public String getPRN() {
        return prn;
    }

    // Setter method for PRN with validation
    public void setPRN(String prn) {
        if (!prn.matches("\\d{11}")) {
            throw new IllegalArgumentException("PRN must be exactly 11 digits.");
        }
        this.prn = prn;
    }

    // Getter method for department
    public String getDept() {
        return dept;
    }

    // Setter method for department with validation
    public void setDept(String dept) {
        if (dept == null || dept.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }
        this.dept = dept;
    }

    // Getter method for batch
    public String getBatch() {
        return batch;
    }

    // Setter method for batch with validation
    public void setBatch(String batch) {
        if (batch == null || batch.trim().isEmpty()) {
            throw new IllegalArgumentException("Batch cannot be empty.");
        }
        this.batch = batch;
    }

    // Getter method for CGPA
    public float getCGPA() {
        return cgpa;
    }

    // Setter method for CGPA with validation
    public void setCGPA(float cgpa) {
        if (cgpa < 0.0 || cgpa > 10.0) {
            throw new IllegalArgumentException("CGPA must be between 0.0 and 10.0.");
        }
        this.cgpa = cgpa;
    }

    // Method to display student details in a readable format
    public void display() {
        System.out.println("Name: " + name +
                           " | PRN: " + prn +
                           " | Dept: " + dept +
                           " | Batch: " + batch +
                           " | CGPA: " + cgpa);
    }
}
