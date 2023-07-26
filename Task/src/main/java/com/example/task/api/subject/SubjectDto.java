package com.example.task.api.subject;

import com.example.task.domain.subject.Subject;

public record SubjectDto(Long id, String name) {

    public static SubjectDto fromDomain(Subject subject) {
        return new SubjectDto(
                subject.getId(),
                subject.getName()
        );
    }
}
