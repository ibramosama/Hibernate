package org.example;

import org.example.Entities.Course;
import org.example.Entities.Instructor;
import org.example.Entities.InstructorDetails;
import org.example.Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Student.class).buildSessionFactory();
        //open session
        Session session = sessionFactory.openSession();

        //begin transaction
        session.beginTransaction();
        //do my actions on db

        //Create
//        InstructorDetails instructorDetails=new InstructorDetails("youtube","swimming");
//        Instructor ins1 = new Instructor("Poula", "Osama", "ibram.osama17@gmail.com",instructorDetails);
//        session.persist(ins1);
          Instructor instructor=session.get(Instructor.class,11);
//        List<Course> courses=List.of(new Course("Java",instructor),new Course("C#",instructor),new Course("Python",instructor));

//        instructor.addCourse(new Course("Java",instructor));
//        session.persist(instructor);
        Student student=new Student("Sherif","Essam","Sherif");
        Course course=new Course("Java",instructor);
        course.add(student);
        session.persist(course);


        //Read
//        List<Instructor> instructor = session.createQuery("from Instructor i ", Instructor.class).getResultList();
//        instructor.forEach(System.out::println);

        //Update
//        Instructor instructor1=session.get(Instructor.class,1);
//        instructor1.setEmail("ibram.osama@gmail.com");
//        session.persist(instructor1);
//
//
//        //delete
//        Instructor instructor2=session.get(Instructor.class,4);
//        session.remove(instructor2);

        //commit transaction
        session.getTransaction().commit();

        //close session
        session.close();
        // close session factory
        sessionFactory.close();
    }
}