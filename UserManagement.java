package features;

import java.util.ArrayList;
import models.User;

public class UserManagement {
    private ArrayList<User> users;

    public UserManagement(ArrayList<User> users) {
        this.users = users;
    }

    // Add Student
    public void addStudent(User student) {
        users.add(student);
        System.out.println("Student added: " + student.getUsername());
    }

    // Delete Student
    public void deleteStudent(String email) {
        boolean removed = users.removeIf(u -> u.getEmail().equals(email) && u.getUserType().equals("student"));
        if (removed) {
            System.out.println("Student deleted with email: " + email);
        } else {
            System.out.println("No student found with email: " + email);
        }
    }

    public ArrayList<User> getUsers() { return users; }
}
