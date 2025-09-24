package features;

import models.CourseModel;
import util.Utils;

public class CourseManagement {
    public CourseModel addCourse(String name, String duration) {
        CourseModel c = new CourseModel(Utils.generateCourseId(), name, duration);
        Utils.addCourse(c);
        return c;
    }

    public boolean deleteCourse(String id) {
        for (int i = 0; i < Utils.courseCount; i++) {
            if (Utils.courses[i].courseId.equals(id)) {
                for (int j = i; j < Utils.courseCount - 1; j++) {
                    Utils.courses[j] = Utils.courses[j + 1];
                }
                Utils.courses[--Utils.courseCount] = null;

                // remove from users
                for (int k = 0; k < Utils.userCount; k++) {
                    Utils.users[k].removeCourse(id);
                }
                return true;
            }
        }
        return false;
    }
}
