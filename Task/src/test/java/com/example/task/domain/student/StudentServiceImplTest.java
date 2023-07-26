package com.example.task.domain.student;

import com.example.task.domain.classes.Classes;
import com.example.task.infrastructure.ClassesRepository;
import com.example.task.infrastructure.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ClassesRepository classesRepository;

    @InjectMocks
    private StudentServiceImpl studentService;


    @Test
    void shouldRegisterNewStudent() {

        //given
        String name = "Karolina";
        String surname = "Nowak";
        String email = "k.nowak@wp.com";
        Long classesId = 1L;

        Classes classes = new Classes("Management");
        Mockito.when(classesRepository.findById(classesId)).thenReturn(Optional.of(classes));

        Student expectedStudent = new Student(name, surname, email, classes);
        Mockito.when(studentRepository.save(any(Student.class))).thenReturn(expectedStudent);

        //when
        Student result = studentService.registerNewStudent(name, surname, email, classesId);

        //then
        assertEquals(expectedStudent, result);

    }

    @Test
    void shouldGetStudentByStudentId() {
        //given
        Long studentId = 1L;
        Student expectedStudent = new Student("Karolina", "Nowak", "k.nowak@wp.com", new Classes("Physics"));
        Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(expectedStudent));

        //when
        Optional<Student> result = studentService.getStudent(studentId);

        //then
        assertTrue(result.isPresent());
        assertEquals(expectedStudent, result.get());
    }
}