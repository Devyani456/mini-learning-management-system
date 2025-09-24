package models;

public class CourseModel {
    public String courseId;
    public String courseName;
    public String courseDuration;

    public CourseModel(String courseId, String courseName, String courseDuration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }
}
