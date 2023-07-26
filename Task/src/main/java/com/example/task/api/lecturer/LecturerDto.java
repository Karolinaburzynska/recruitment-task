package com.example.task.api.lecturer;

import com.example.task.domain.lecturer.Lecturer;

public record LecturerDto(
        Long id,
        String name,
        String surname,
        String email,
        Long subjectId
) {

    public static LecturerDto fromDomain(Lecturer lecturer){
        return new LecturerDto(
                lecturer.getId(),
                lecturer.getName(),
                lecturer.getSurname(),
                lecturer.getEmail(),
                lecturer.getSubjectId()
        );
    }
}
