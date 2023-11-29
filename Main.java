import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("             WELCOME TO HARAMAYA UNIVERSITY     ");
        System.out.println("                     HEAD REGISTRAR             ");
        System.out.println("        COLLEGE OF COMPUTING AND INFORMATICS        ");
        Scanner scanner = new Scanner(System.in);
        RegistrationSystem registrationSystem = new RegistrationSystem();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register a new Regular Student");
            System.out.println("2. Register a new Extension Student");
            System.out.println("3. Remove an existing student");
            System.out.println("4. Display all registered students");
            System.out.println("5. Generate registration slips");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerRegularStudent(scanner, registrationSystem);
                    break;

                case 2:
                    registerExtensionStudent(scanner, registrationSystem);
                    break;

                case 3:
                    System.out.print("Enter the ID of the student to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    registrationSystem.removeStudent(removeId);
                    break;

                case 4:
                    registrationSystem.displayAllStudents();
                    break;

                case 5:
                    registrationSystem.generateRegistrationSlips();
                    break;

                case 6:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }

    private static void registerRegularStudent(Scanner scanner, RegistrationSystem registrationSystem) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        int id;
        while (true) {
            try {
                System.out.print("Enter student ID (6-digit positive number): ");
                id = validateId(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int year;
        while (true) {
            try {
                System.out.print("Enter student year (1 to 7): ");
                year = validateYear(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int semester;
        while (true) {
            try {
                System.out.print("Enter student semester (1 or 2): ");
                semester = validateSemester(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String department = chooseDepartment(scanner);

        RegularStudent regularStudent = new RegularStudent(name, id, year, semester, department);
        registrationSystem.registerStudent(regularStudent);
        System.out.println("Regular Student registered successfully!");
    }

    private static void registerExtensionStudent(Scanner scanner, RegistrationSystem registrationSystem) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        int id;
        while (true) {
            try {
                System.out.print("Enter student ID (6-digit positive number): ");
                id = validateId(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int year;
        while (true) {
            try {
                System.out.print("Enter student year (1 to 7): ");
                year = validateYear(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int semester;
        while (true) {
            try {
                System.out.print("Enter student semester (1 or 2): ");
                semester = validateSemester(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String department = chooseDepartment(scanner);

        ExtensionStudent extensionStudent = new ExtensionStudent(name, id, year, semester, department);
        registrationSystem.registerStudent(extensionStudent);
        System.out.println("Extension Student registered successfully!");
    }

    private static String chooseDepartment(Scanner scanner) {
        System.out.println("Choose a department:");
        System.out.println("1. Software Engineering");
        System.out.println("2. Computer Science");
        System.out.println("3. Information System");
        System.out.println("4. Information Science");
        System.out.println("5. Information Technology");
        System.out.println("6. Statistics");

        int departmentChoice;
        while (true) {
            try {
                System.out.print("Enter the number of the chosen department: ");
                departmentChoice = Integer.parseInt(scanner.nextLine());
                if (departmentChoice < 1 || departmentChoice > 6) {
                    throw new IllegalArgumentException("Invalid department choice. Please enter a number between 1 and 6.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        switch (departmentChoice) {
            case 1:
                return "Software Engineering";
            case 2:
                return "Computer Science";
            case 3:
                return "Information System";
            case 4:
                return "Information Science";
            case 5:
                return "Information Technology";
            case 6:
                return "Statistics";
            default:
                return null;
        }
    }

    private static int validateId(String input) {
        int id;
        try {
            id = Integer.parseInt(input);
            if (id < 100000 || id > 999999) {
                throw new IllegalArgumentException("ID must be a 6-digit positive number.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a number.");
        }
        return id;
    }

    private static int validateYear(String input) {
        int year;
        try {
            year = Integer.parseInt(input);
            if (year < 1 || year > 7) {
                throw new IllegalArgumentException("Year must be between 1 and 7.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a number.");
        }
        return year;
    }

    private static int validateSemester(String input) {
        int semester;
        try {
            semester = Integer.parseInt(input);
            if (semester < 1 || semester > 2) {
                throw new IllegalArgumentException("Semester must be between 1 and 2.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a number.");
        }
        return semester;
    }
}
