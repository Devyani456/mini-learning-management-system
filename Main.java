package main;

import features.CourseManagement;
import features.EnrollmentManagement;
import features.UserManagement;
import java.util.ArrayList;
import models.*;
import util.Utils;

public class Main {
    private static int userIdCounter = 1;
    private static int courseIdCounter = 0;

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<CourseModel> courses = new ArrayList<>();

        // Managers
        UserManagement userMgmt = new UserManagement(users);
        CourseManagement courseMgmt = new CourseManagement(courses);
        EnrollmentManagement enrollMgmt = new EnrollmentManagement(users);

        // Create an Admin
        users.add(new User(userIdCounter++, "Admin", "admin@gmail.com", "1234567890", "admin123", "admin"));

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Login");
            System.out.println("2. Register (Student)");
            System.out.println("3. Exit");
            int choice;
            try {
                choice = Integer.parseInt(Utils.input("Enter choice"));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 1) {
                String email = Utils.input("Email");
                String password = Utils.input("Password");
                User loggedIn = enrollMgmt.login(new LoginModel(email, password));

                if (loggedIn != null) { // User session loop
                    if (loggedIn.getUserType().equals("admin")) {
                        // Admin Menu
                        System.out.println("\nAdmin Menu: 1.Add Student 2.Delete Student 3.Add Course 4.Delete Course 5.Logout");
                        int adminChoice;
                        try {
                            adminChoice = Integer.parseInt(Utils.input("Enter option"));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            continue;
                        }
                        switch (adminChoice) {
                            case 1:
                                String name = Utils.input("Student name");
                                String mail = Utils.input("Student email");
                                String phone = Utils.input("Phone");
                                String pass = Utils.input("Password");
                                userMgmt.addStudent(new User(userIdCounter++, name, mail, phone, pass, "student"));
                                break;
                            case 2:
                                String studentMail = Utils.input("Student email to delete");
                                userMgmt.deleteStudent(studentMail);
                                break;
                            case 3:
                                String cname = Utils.input("Course Name");
                                String cdur = Utils.input("Course Duration");
                                courseMgmt.addCourse(new CourseModel(++courseIdCounter, cname, cdur));
                                break;
                            case 4:
                                try {
                                    int cid = Integer.parseInt(Utils.input("Course ID to delete"));
                                    // Also remove course from all enrolled students to maintain data integrity
                                    for (User u : users) {
                                        u.getCourses().removeIf(c -> c.getCourseId() == cid);
                    while (true) { // Keep user logged in until they choose to logout
                        if (loggedIn.getUserType().equals("admin")) {
                            // Admin Menu
                            System.out.println("\nAdmin Menu: 1.Add Student 2.Delete Student 3.Add Course 4.Delete Course 5.Logout");
                            int adminChoice;
                            try {
                                adminChoice = Integer.parseInt(Utils.input("Enter option"));
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                continue;
                            }

                            if (adminChoice == 5) {
                                System.out.println("Logging out...");
                                break; // Exit user session loop
                            }

                            switch (adminChoice) {
                                case 1:
                                    String name = Utils.input("Student name");
                                    String mail = Utils.input("Student email");
                                    String phone = Utils.input("Phone");
                                    String pass = Utils.input("Password");
                                    userMgmt.addStudent(new User(userIdCounter++, name, mail, phone, pass, "student"));
                                    break;
                                case 2:
                                    String studentMail = Utils.input("Student email to delete");
                                    userMgmt.deleteStudent(studentMail);
                                    break;
                                case 3:
                                    String cname = Utils.input("Course Name");
                                    String cdur = Utils.input("Course Duration");
                                    courseMgmt.addCourse(new CourseModel(++courseIdCounter, cname, cdur));
                                    break;
                                case 4:
                                    try {
                                        int cid = Integer.parseInt(Utils.input("Course ID to delete"));
                                        // Also remove course from all enrolled students to maintain data integrity
                                        for (User u : users) {
                                            u.getCourses().removeIf(c -> c.getCourseId() == cid);
                                        }
                                        courseMgmt.deleteCourse(cid);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid Course ID. Please enter a number.");
                                    }
                                    courseMgmt.deleteCourse(cid);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid Course ID. Please enter a number.");
                                }
                                break;
                            case 5:
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                                    break;
                            }
                        } else {
                            // Student Menu
                            System.out.println("\nStudent Menu: 1.Enroll Course 2.Remove Course 3.View My Courses 4.Logout");
                            int stuChoice;
                            try {
                                stuChoice = Integer.parseInt(Utils.input("Enter option"));
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                continue;
                            }

                            if (stuChoice == 4) {
                                System.out.println("Logging out...");
                                break; // This will break the switch and the outer 'if (loggedIn != null)' will handle the rest
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }
                    } else {
                        // Student Menu
                        System.out.println("\nStudent Menu: 1.Enroll Course 2.Remove Course 3.View My Courses 4.Logout");
                        int stuChoice;
                        try {
                            stuChoice = Integer.parseInt(Utils.input("Enter option"));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            continue;
                        }
                        switch (stuChoice) {
                            case 1:
                                try {
                                    int cid = Integer.parseInt(Utils.input("Enter Course ID to enroll"));
                                    CourseModel courseToEnroll = courseMgmt.getCourses().stream()
                                            .filter(c -> c.getCourseId() == cid)
                                            .findFirst()
                                            .orElse(null);
                                break; // Exit user session loop
                            }

                                    if (courseToEnroll != null) {
                                        if (loggedIn.getCourses().stream().anyMatch(c -> c.getCourseId() == cid)) {
                                            System.out.println("You are already enrolled in this course.");
                            switch (stuChoice) {
                                case 1:
                                    try {
                                        int cid = Integer.parseInt(Utils.input("Enter Course ID to enroll"));
                                        CourseModel courseToEnroll = courseMgmt.getCourses().stream()
                                                .filter(c -> c.getCourseId() == cid)
                                                .findFirst()
                                                .orElse(null);

                                        if (courseToEnroll != null) {
                                            if (loggedIn.getCourses().stream().anyMatch(c -> c.getCourseId() == cid)) {
                                                System.out.println("You are already enrolled in this course.");
                                            } else {
                                                enrollMgmt.enrollCourse(loggedIn, courseToEnroll);
                                            }
                                        } else {
                                            enrollMgmt.enrollCourse(loggedIn, courseToEnroll);
                                            System.out.println("Course with ID " + cid + " not found.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid Course ID. Please enter a number.");
                                    }
                                    break;
                                case 2:
                                    try {
                                        int cid = Integer.parseInt(Utils.input("Enter Course ID to remove"));
                                        enrollMgmt.removeCourse(loggedIn, cid);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid Course ID. Please enter a number.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("\nYour enrolled courses:");
                                    if (loggedIn.getCourses().isEmpty()) {
                                        System.out.println("You are not enrolled in any courses.");
                                    } else {
                                        System.out.println("Course with ID " + cid + " not found.");
                                        loggedIn.getCourses().forEach(c -> System.out.println(" - ID: " + c.getCourseId() + ", Name: " + c.getCourseName()));
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid Course ID. Please enter a number.");
                                }
                                break;
                            case 2:
                                try {
                                    int cid = Integer.parseInt(Utils.input("Enter Course ID to remove"));
                                    enrollMgmt.removeCourse(loggedIn, cid);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid Course ID. Please enter a number.");
                                }
                                break;
                            case 3:
                                System.out.println("\nYour enrolled courses:");
                                if (loggedIn.getCourses().isEmpty()) {
                                    System.out.println("You are not enrolled in any courses.");
                                } else {
                                    loggedIn.getCourses().forEach(c -> System.out.println(" - ID: " + c.getCourseId() + ", Name: " + c.getCourseName()));
                                }
                                break;
                            case 4:
                                System.out.println("Logging out...");
                                break;
                            default:
                                System.out.println("Invalid option.");
                                break;
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                                    break;
                            }
                        }
                    }
                }
            } else if (choice == 2) {
                String name = Utils.input("Name");
                String mail = Utils.input("Email");
                String phone = Utils.input("Phone");
                String pass = Utils.input("Password");
                enrollMgmt.register(new User(userIdCounter++, name, mail, phone, pass, "student"));
            } else {
                break;
            }
        }
    }
}
