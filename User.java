package models;

public class User {
    public String userId;
    public String username;
    public String email;
    public String phone;
    public String password;
    public String userType; // "admin" or "student"
    public CourseModel[] courses; // enrolled courses
    public int courseCount;

    public User(String userId, String username, String email, String phone, String password, String userType) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.userType = userType;
        this.courses = new CourseModel[10]; // max 10 courses
        this.courseCount = 0;
    }

    public boolean addCourse(CourseModel c) {
        if (courseCount < courses.length) {
            courses[courseCount++] = c;
            return true;
        }
        return false;
    }

    public boolean removeCourse(String courseId) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i] != null && courses[i].courseId != null && courses[i].courseId.equals(courseId)) {
                // shift left
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--courseCount] = null;
                return true;
            }
        }
        return false;
    }
}
