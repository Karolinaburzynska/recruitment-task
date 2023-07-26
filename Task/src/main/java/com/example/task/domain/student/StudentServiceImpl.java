package com.example.task.domain.student;

import com.example.task.domain.classes.Classes;
import com.example.task.infrastructure.ClassesRepository;
import com.example.task.infrastructure.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;

    public StudentServiceImpl(StudentRepository studentRepository, ClassesRepository classesRepository) {
        this.studentRepository = studentRepository;
        this.classesRepository = classesRepository;
    }

    @Override
    public Student registerNewStudent(String name, String surname, String email, Long classesId) {
        Classes classes = classesRepository.findById(classesId).orElseThrow();
        Student student = new Student(name, surname, email, classes);
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudent(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
}
