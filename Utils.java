package util;

import models.CourseModel;
import models.User;

public class Utils {
    public static User[] users = new User[100];
    public static int userCount = 0;

    public static CourseModel[] courses = new CourseModel[100];
    public static int courseCount = 0;

    // helper: generate simple IDs
    private static int uid = 1;
    private static int cid = 1;

    public static String generateUserId() {
        return "U" + (uid++);
    }

    public static String generateCourseId() {
        return "C" + (cid++);
    }

    // to add user
    public static void addUser(User u) {
        users[userCount++] = u;
    }

    // add course 
    public static void addCourse(CourseModel c) {
        courses[courseCount++] = c;
    }

    // to find user by email
    public static User findUserByEmail(String email) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].email.equals(email)) return users[i];
        }
        return null;
    }

    // find user by id
    public static User findUserById(String id) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].userId.equals(id)) return users[i];
        }
        return null;
    }

    // find course by id
    public static CourseModel findCourseById(String id) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].courseId.equals(id)) return courses[i];
        }
        return null;
    }
}
