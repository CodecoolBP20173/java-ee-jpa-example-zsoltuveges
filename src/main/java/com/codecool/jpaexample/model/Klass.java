package com.codecool.jpaexample.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "class")
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated
    private CCLocation ccLocation;

    @OneToMany(mappedBy = "klass")
    private Set<Student> students = new HashSet<>();

    public Klass() {
    }

    public Klass(String name, CCLocation location) {
        this.name = name;
        this.ccLocation = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.setKlass(this);
        students.add(student);
    }

    public CCLocation getCcLocation() {
        return ccLocation;
    }

    public void setCcLocation(CCLocation ccLocation) {
        this.ccLocation = ccLocation;
    }
}
