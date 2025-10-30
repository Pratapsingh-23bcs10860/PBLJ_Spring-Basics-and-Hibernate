package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Create
        createStudent("Ravi", "Spring Boot");

        // Read
        readStudents();

        // Update
        updateStudent(1, "Microservices");

        // Delete
        deleteStudent(2);
    }

    static void createStudent(String name, String course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student s = new Student(name, course);
        session.save(s);
        tx.commit();
        session.close();
        System.out.println("✅ Student saved successfully");
    }

    static void readStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> list = session.createQuery("from Student", Student.class).list();
        for (Student s : list) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getCourse());
        }
        session.close();
    }

    static void updateStudent(int id, String newCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student s = session.get(Student.class, id);
        s.setCourse(newCourse);
        session.update(s);
        tx.commit();
        session.close();
        System.out.println("✅ Student updated");
    }

    static void deleteStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student s = session.get(Student.class, id);
        if (s != null) session.delete(s);
        tx.commit();
        session.close();
        System.out.println("✅ Student deleted");
    }
}
