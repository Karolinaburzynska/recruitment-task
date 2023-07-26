package com.example.task.domain.student;

import com.example.task.domain.classes.Classes;
import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    @ManyToOne
    private Classes classes;

    public Student() {
    }

    public Student(String name, String surname, String email, Classes classes) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.classes = classes;
    }

    public Student(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Student(Long id, String name, String surname, String email, Classes classes) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
