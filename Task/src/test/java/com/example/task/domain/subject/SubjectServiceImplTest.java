package com.example.task.domain.subject;

import com.example.task.infrastructure.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class SubjectServiceImplTest {

    @Mock
    SubjectRepository repositoryMock;

    @InjectMocks
    SubjectServiceImpl subjectService;

    @Test
    void shouldRegisterNewSubject() {

        //given
        String name = "Mathematics";
        Subject expectedSubject = new Subject(name);
        Mockito.when(repositoryMock.save(any(Subject.class))).thenReturn(expectedSubject);

        //when
        Subject result = subjectService.registerNewSubject(name);

        //then
        assertEquals(expectedSubject, result);

    }

    @Test
    void shouldGetSubject() {
        //given

        Long subjectId = 1L;
        Subject expectedSubject = new Subject("Biology");
        Mockito.when(repositoryMock.findById(subjectId)).thenReturn(Optional.of(expectedSubject));

        //when
        Optional<Subject> result = subjectService.getSubject(subjectId);

        //then
        assertTrue(result.isPresent());
        assertEquals(expectedSubject, result.get());
    }

}