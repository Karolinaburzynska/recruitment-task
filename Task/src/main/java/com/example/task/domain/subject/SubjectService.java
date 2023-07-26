package com.example.task.domain.subject;

import java.util.Optional;

public interface SubjectService {

    Subject registerNewSubject(String name);

    Optional<Subject> getSubject(Long subjectId);

    Subject updateSubject(Subject subject);
}
