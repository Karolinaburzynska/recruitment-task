package com.example.task.domain.lecturer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Long subjectId;

    public Lecturer() {
    }

    public Lecturer(String name, String surname, String email, Long subjectId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.subjectId = subjectId;
    }

    public Lecturer(Long id, String name, String surname, String email, Long subjectId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.subjectId = subjectId;
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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}

