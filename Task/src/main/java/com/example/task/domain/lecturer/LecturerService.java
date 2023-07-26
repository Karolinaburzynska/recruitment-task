package com.example.task.domain.lecturer;

import java.util.Optional;

public interface LecturerService {

    Lecturer registerNewLecturer(String name, String surname, String email, Long subjectId);

    Optional<Lecturer> getLecturer(Long lecturerId);

    void deleteLecturerById(Long lecturerId);


}
