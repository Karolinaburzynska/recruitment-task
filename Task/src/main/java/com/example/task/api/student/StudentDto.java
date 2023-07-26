package com.example.task.api.student;

import com.example.task.domain.student.Student;

public record StudentDto(
        Long id,
        String name,
        String surname,
        String email,
        Long classesId
) {

    public static StudentDto fromDomain(Student student) {
        return new StudentDto(student.getId(),
                student.getName(),
                student.getSurname(),
                student.getEmail(),
                student.getClasses().getId());
    }


}
