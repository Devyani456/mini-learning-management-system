package features;

import java.util.ArrayList;
import models.CourseModel;
import models.LoginModel;
import models.User;

public class EnrollmentManagement {
    private ArrayList<User> users;

    public EnrollmentManagement(ArrayList<User> users) {
        this.users = users;
    }

    // Register new user
    public void register(User user) {
        users.add(user);
        System.out.println("Registered user: " + user.getUsername());
    }

    // Login
    public User login(LoginModel login) {
        for (User u : users) {
            if (u.getEmail().equals(login.getEmail()) && u.getPassword().equals(login.getPassword())) {
                System.out.println("Login successful: " + u.getUsername());
                return u;
            }
        }
        System.out.println("Invalid login");
        return null;
    }

    // Enroll student in course
    public void enrollCourse(User student, CourseModel course) {
        if (student.getUserType().equals("student")) {
            student.getCourses().add(course);
            System.out.println("Enrolled " + student.getUsername() + " in " + course.getCourseName());
        }
    }

    // Remove course from student
    public void removeCourse(User student, int courseId) {
        boolean removed = student.getCourses().removeIf(c -> c.getCourseId() == courseId);
        if (removed) {
            System.out.println("Removed course ID " + courseId + " from " + student.getUsername());
        } else {
            System.out.println("Course ID " + courseId + " not found in " + student.getUsername() + "'s enrollments.");
        }
    }
}
