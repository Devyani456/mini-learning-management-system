package models;

public class CourseModel {
    private int courseId;
    private String courseName;
    private String courseDuration;

    public CourseModel(int courseId, String courseName, String courseDuration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }

    // Getters
    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getCourseDuration() { return courseDuration; }
}
