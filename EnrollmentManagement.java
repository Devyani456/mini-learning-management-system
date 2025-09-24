package features;

import models.CourseModel;
import models.LoginModel;
import models.User;
import util.Utils;

public class EnrollmentManagement {

    public User register(String username, String email, String phone, String password, String type) {
        User u = new User(Utils.generateUserId(), username, email, phone, password, type);
        Utils.addUser(u);
        return u;
    }

    public User login(LoginModel lm) {
        User u = Utils.findUserByEmail(lm.email);
        if (u != null && u.password.equals(lm.password)) {
            return u;
        }
        return null;
    }

    public boolean enroll(String studentId, String courseId) {
        User u = Utils.findUserById(studentId);
        CourseModel c = Utils.findCourseById(courseId);
        if (u != null && c != null && u.userType.equals("student")) {
            return u.addCourse(c);
        }
        return false;
    }

    public boolean unenroll(String studentId, String courseId) {
        User u = Utils.findUserById(studentId);
        if (u != null && u.userType.equals("student")) {
            return u.removeCourse(courseId);
        }
        return false;
    }
}
