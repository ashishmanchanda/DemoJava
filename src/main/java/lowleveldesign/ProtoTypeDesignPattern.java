package lowleveldesign;

// Prototype interface
interface StudentPrototype {
    StudentPrototype clone();
}

// Concrete prototype class
public class Student implements StudentPrototype {
    int id;
    String name;
    String branch;
    boolean inHighSchool;
    private int rollNo;

    Student() {
    }

    // Clone constructor for efficient copying
    Student(int id, String name, String branch, int rollNo) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.rollNo = rollNo;
    }

    public void setInHighSchool(boolean inHighSchool) {
        this.inHighSchool = inHighSchool;
    }

    @Override
    StudentPrototype clone() {
        return new Student(id, name, branch, rollNo);
    }

    public void printDetails() {
        System.out.println("=== Student Details ===");
        System.out.print(this + ": ");
        System.out.println("id: " + id + ", name: " + name + ", branch: " + branch + ", rollNo: " + rollNo + ", inHighSchool: " + inHighSchool);
// Client}
    }

}
class DemoSolution {
    public static void main(String[] args) {
// Create initial prototypes (expensive operations)
        Student student = new Student(5, "Rita", "CSE", 224);
        student.printDetails();
        Student studentClone = (Student) student.clone();
        studentClone.setInHighSchool(true);
        studentClone.printDetails();
        System.out.println("Same object? " + (student == studentClone));// false
    }
}
