package com.example.task.domain.lecturer;

import com.example.task.domain.subject.Subject;
import com.example.task.infrastructure.LecturerRepository;
import com.example.task.infrastructure.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class LecturerServiceImplTest {

    @Mock
    private LecturerRepository lecturerRepository;

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private LecturerServiceImpl lecturerService;


    @Test
    void shouldRegisterNewLecturer() {
        //given
        String name = "Jan";
        String surname = "Kowalski";
        String email = "j.kowalski@wp.com";
        Long subjectId = 1L;
        Subject subject = new Subject("Mathematics");
        Mockito.when(subjectRepository.findById(subjectId)).thenReturn(Optional.of(subject));
        Lecturer expectedLecturer = new Lecturer(name, surname, email, subjectId);
        Mockito.when(lecturerRepository.save(any(Lecturer.class))).thenReturn(expectedLecturer);

        //when
        Lecturer result = lecturerService.registerNewLecturer(name, surname, email, subjectId);

        //then
        assertEquals(expectedLecturer, result);
    }
}