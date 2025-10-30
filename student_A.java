package com.example;

public class Student {
    private Course course;

    // Constructor-based Dependency Injection
    public Student(Course course) {
        this.course = course;
    }

    public void showDetails() {
        System.out.println("Student enrolled in: ");
        course.displayCourse();
    }
}
