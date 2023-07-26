package com.example.task.domain.student;

import java.util.Optional;

public interface StudentService {

    Student registerNewStudent(String name, String surname, String email, Long classesId);

    Optional<Student> getStudent(Long studentId);

    void deleteStudentById(Long studentId);

    Student updateStudent(Student student);
}
