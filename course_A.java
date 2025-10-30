package com.example;

public class Course {
    private String courseName;

    public Course() {
        this.courseName = "Spring Framework Fundamentals";
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayCourse() {
        System.out.println("Course Enrolled: " + courseName);
    }
}
