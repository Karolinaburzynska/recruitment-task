package com.example.task.api.student;

import com.example.task.domain.student.Student;
import com.example.task.domain.student.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.example.task.api.student.StudentController.BASE_PATH_STUDENT;

@RestController
@RequestMapping(BASE_PATH_STUDENT)
public class StudentController {


    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> registerNewStudent(@RequestBody @Valid StudentRegisterRequest request) {
        Student newStudent = studentService.registerNewStudent(request.getName(), request.getSurname(), request.getEmail(), request.getClassesId());
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @GetMapping("/{studentId}")
    ResponseEntity<StudentDto> getSingleStudent(@PathVariable Long studentId) {
        return ResponseEntity.of(studentService.getStudent(studentId).map(StudentDto::fromDomain));
    }

    @DeleteMapping("/{deleteStudentId}")
    public ResponseEntity<StudentDto> deleteSingleStudent(@PathVariable("deleteStudentId") Long studentId) {
        studentService.deleteStudentById(studentId);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody StudentRegisterRequest request) {
        Student student = new Student(studentId, request.getName(), request.getSurname(), request.getEmail());
        Student updateStudent = studentService.updateStudent(student);
        return ResponseEntity.created(URI.create("/students")).body(updateStudent);
    }

    static final String BASE_PATH_STUDENT = "/students";

}
