package models;

import java.util.ArrayList;

public class User {
    private int userId;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String userType; // "admin" or "student"
    private ArrayList<CourseModel> courses;

    public User(int userId, String username, String email, String phone, String password, String userType) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.userType = userType;
        this.courses = new ArrayList<>();
    }

    // Getters & Setters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public String getUserType() { return userType; }
    public ArrayList<CourseModel> getCourses() { return courses; }
}
