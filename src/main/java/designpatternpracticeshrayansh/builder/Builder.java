package designpatternpracticeshrayansh.builder;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

// Step : Product class - Complex Student object
class Student {

    // mandatory fields
    int rollNumber;
    int age;
    String name;
    String branch;
    // optional fields
    String fatherName;
    String motherName;
    List<String> subjects;
    String mobileNo;
    String emailId;

    // Constructor - package private, only the builder can create
    Student(StudentBuilder builder) {
        this.rollNumber = builder.rollNumber;
        this.age = builder.age;
        this.name = builder.name;
        this.branch = builder.branch;
        this.fatherName = builder.fatherName;
        this.motherName = builder.motherName;
        this.subjects = builder.subjects;
        this.mobileNo = builder.mobileNo;
        this.emailId = builder.emailId;
    }

    public String toString() {
        return " roll number: " + this.rollNumber +
                " age: " + this.age +
                " name: " + this.name +
                " branch: " + this.branch +
                " father name: " + this.fatherName +
                " mother name: " + this.motherName +
                " subjects: " + subjects.get(0) + "," +
                subjects.get(1) + "," + subjects.get(2) +
                " mobile no: " + this.mobileNo +
                " email id: " + this.emailId;
    }

}
// Step : Abstract Builder interface
 abstract class StudentBuilder {


    // mandatory fields
    int rollNumber;
    int age;
    String name;
    String branch;
    // optional fields
    String fatherName;
    String motherName;
    List<String> subjects;
    String mobileNo;
    String emailId;

    public StudentBuilder setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public StudentBuilder setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public StudentBuilder setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    abstract public StudentBuilder setSubjects();

    // Build method
    public Student build() {
        return new Student(this);
    }

}
// Step : Concrete Builder for Engineering Students
 class EngineeringStudentBuilder extends StudentBuilder {

    // Engineering-specific methods
    @Override
    public StudentBuilder setSubjects() {
        List<String> enggSubjectsList = new ArrayList<>();
        enggSubjectsList.add("Operating Systems");
        enggSubjectsList.add("Computer Architecture");
        enggSubjectsList.add("Data Structures");

        enggSubjectsList.add("DBMS");
        this.subjects = enggSubjectsList;
        return this;
    }
}

// Step : Concrete Builder for MBA Students
 class MBAStudentBuilder extends StudentBuilder {

    // MBA-specific methods
    @Override
    public StudentBuilder setSubjects() {
        List<String> mbaSubjectsList = new ArrayList<>();
        mbaSubjectsList.add("Micro Economics");
        mbaSubjectsList.add("Business Studies");
        mbaSubjectsList.add("Operations Management");
        mbaSubjectsList.add("Financial Management");
        this.subjects = mbaSubjectsList;
        return this;
    }
}
// Step : Director class for common student registration processes
 class StudentRegistrationDirector {

    StudentBuilder studentBuilder;

    StudentRegistrationDirector(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if (studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudent();
        } else if (studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    private Student createEngineeringStudent() {
        return studentBuilder.setRollNumber(22) //
                .setAge(21)
                .setName("John")
                .setFatherName("Paul")
                .setMotherName("Jane")
                .setBranch("Computer Science and Engineering")
                .setSubjects() // Engineering-specific method
                .build();
    }

    private Student createMBAStudent() {
        return studentBuilder.setRollNumber(11) // MBAStudentBuilder
                .setAge(22)
                .setName("Sarah")
                .setFatherName("Gabriel")
                .setMotherName("Taylor")
                .setBranch("Business Administration")
                .setSubjects() // MBA-specific method
                .setMobileNo("")
                .setEmailId("sarahgabriel@iitb.com")
                .build();
    }
}
// Step : Client demonstration
 class Client {

    public static void main(String[] args) {
        System.out.println("===== Builder Pattern =====");


        // Create director objects
        StudentRegistrationDirector enggStudentDirector = new
                StudentRegistrationDirector(new EngineeringStudentBuilder());
        StudentRegistrationDirector mbaStudentDirector = new
                StudentRegistrationDirector(new MBAStudentBuilder());

        // Create students using different builders
        Student engineerStudent = enggStudentDirector.createStudent();
        Student mbaStudent = mbaStudentDirector.createStudent();

        // Print student details
        System.out.println("===> Student details:" +
                engineerStudent.toString());
        System.out.println("===> Student details:" +
                mbaStudent.toString());

    }
}