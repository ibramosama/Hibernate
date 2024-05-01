package org.example.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="title")
    private String title;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @ManyToMany(cascade={CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable(name ="course_student", joinColumns ={ @JoinColumn(name= "course_id")},inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;
    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public Course(String title, Instructor instructor) {

        this.title = title;
        this.instructor = instructor;
    }

    public Course(String title, Instructor instructor, List<Student> students) {
        this.title = title;
        this.instructor = instructor;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public void add(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
