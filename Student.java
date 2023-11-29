import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

abstract class Student {
    protected String name;
    protected int id;
    protected int year;
    protected int semester;
    protected String department;

    public Student(String name, int id, int year, int semester, String department) {
        this.name = name;
        this.id = id;
        this.year = year;
        this.semester = semester;
        this.department = department;
    }

    public abstract String getStudentType();

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return ".....................................................................\n" +
                getStudentType() + "\nID: " + id + "\nName: " + name + "\nYear: " + year +
                "\nSemester: " + semester + "\nDepartment: " + department + "\n....................................................................." +
                "\nAcademic Semester courses: " +"\n" + getRandomCourse() +
                "\n........................................................................";
    }

    private String getRandomCourse() {
        String[] courses;

        switch (department) {
            case "Software Engineering":
                courses = new String[]{"Objiect oriented programming", "Data structure and algorithms", "Operating System and System programming", "Computer organization and Architecture", "Fundamental of networking", "Statistics and probablity"};
                break;

            case "Computer Science":
                courses = new String[]{"Computer Networks", "Operating Systems", "Artificial Intelligence", "Data Mining", "Computer Graphics", "Computer Security"};
                break;

            case "Information System":
                courses = new String[]{"Information Systems Analysis", "Business Intelligence", "Enterprise Architecture", "Database Design", "Web Application Development", "Project Management"};
                break;

            case "Information Science":
                courses = new String[]{"Data Structures", "Information Retrieval", "Human-Computer Interaction", "Information Ethics", "Digital Libraries", "Information Policy"};
                break;

            case "Information Technology":
                courses = new String[]{"Network Administration", "Cybersecurity Fundamentals", "IT Project Management", "Cloud Computing", "System Analysis and Design", "IT Governance"};
                break;

            case "Statistics":
                courses = new String[]{"Statistical Methods", "Regression Analysis", "Probability Theory", "Time Series Analysis", "Multivariate Analysis", "Experimental Design"};
                break;

            default:
                courses = new String[]{"Course 1", "Course 2", "Course 3", "Course 4", "Course 5", "Course 6"};
                break;
        }

        return String.join("\n", courses);
    }
}
