package com.example.task.domain.lecturer;

import com.example.task.domain.subject.Subject;
import com.example.task.infrastructure.LecturerRepository;
import com.example.task.infrastructure.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;
    private final SubjectRepository subjectRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository, SubjectRepository subjectRepository) {
        this.lecturerRepository = lecturerRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Lecturer registerNewLecturer(String name, String surname, String email, Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        Lecturer lecturer = new Lecturer(name, surname, email, subjectId);
        return lecturerRepository.save(lecturer);
    }

    @Override
    public Optional<Lecturer> getLecturer(Long lecturerId) {
        return lecturerRepository.findById(lecturerId);
    }

    @Override
    public void deleteLecturerById(Long lecturerId) {
        lecturerRepository.deleteById(lecturerId);
    }


}
