package com.example.task.domain.subject;

import com.example.task.infrastructure.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject registerNewSubject(String name) {
        Subject subject = new Subject(name);
        return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> getSubject(Long subjectId) {
        return subjectRepository.findById(subjectId);
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
