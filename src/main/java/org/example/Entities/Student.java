package org.example.Entities;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @ManyToMany(cascade={CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable(name ="course_student", joinColumns ={ @JoinColumn(name= "student_id")},inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courseList;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, List<Course> courseList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courseList = courseList;
    }

    public Student( String firstName,String lastName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void add(Course course) {
        if (courseList == null) {
            courseList = new ArrayList<>();
        }
        courseList.add(course);
    }
    public void addCourses(List<Course> courses) {
        if (courseList == null) {
            courseList = new ArrayList<>();
        }
        courseList.addAll(courses);
    }
}
