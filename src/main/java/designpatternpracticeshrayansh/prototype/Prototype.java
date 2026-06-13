package designpatternpracticeshrayansh.prototype;

 class Student {


    int id;
    String name;
    String branch;
    private int rollNo;

    Student() {

    }

    Student(int id, String name, String branch, int rollNo) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.rollNo = rollNo;
    }

    public void printDetails() {
        System.out.println("=== Student Details ===");
        System.out.print(this + ": ");
        System.out.println("Id: " + id + ", Name: " + name + ", Branch: " + branch + ", Roll No: " + rollNo);
    }
}

// Client
 class DemoProblem {
    public static void main(String[] args) {
        Student studentOrg = new Student(1, "Aman", "CSE", 123);
        studentOrg.printDetails();
        // create a clone of the student object
        Student studentClone = new Student();
        studentClone.id = studentOrg.id;
        studentClone.name = studentOrg.name;
        studentClone.branch = studentOrg.branch;
        // studentClone.rollNo = studentOrg.rollNo; // Compilation error
    }
}