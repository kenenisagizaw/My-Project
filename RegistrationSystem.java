import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class RegistrationSystem {
    private List<Student> students;

    public RegistrationSystem() {
        this.students = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public void generateRegistrationSlips() {
        for (Student student : students) {
            System.out.println("\nRegistration Slip for Student ID: " + student.getId());
            System.out.println(student.toString());
        }
    }
}