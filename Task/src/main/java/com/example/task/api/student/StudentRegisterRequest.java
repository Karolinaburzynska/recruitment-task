package com.example.task.api.student;

public class StudentRegisterRequest {
    private String name;
    private String surname;
    private String email;

    private Long classesId;

    public StudentRegisterRequest() {
    }

    public StudentRegisterRequest(String name, String surname, String email, Long classesId) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.classesId = classesId;
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

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
    }
}
