package com.example.task.api.lecturer;

public record LecturerRegisterRequest(
        String name,
        String surname,
        String email,
        Long subjectId
) {
}
