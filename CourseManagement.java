package features;

import java.util.ArrayList;
import models.CourseModel;

public class CourseManagement {
    private ArrayList<CourseModel> courses;

    public CourseManagement(ArrayList<CourseModel> courses) {
        this.courses = courses;
    }

    // Add Course
    public void addCourse(CourseModel course) {
        courses.add(course);
        System.out.println("Course added: " + course.getCourseName());
    }

    // Delete Course
    public void deleteCourse(int courseId) {
        boolean removed = courses.removeIf(c -> c.getCourseId() == courseId);
        if (removed) {
            System.out.println("Course deleted with ID: " + courseId);
        } else {
            System.out.println("Course with ID " + courseId + " not found.");
        }
    }

    public ArrayList<CourseModel> getCourses() { return courses; }
}
