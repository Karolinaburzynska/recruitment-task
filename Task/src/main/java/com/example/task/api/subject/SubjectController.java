package com.example.task.api.subject;

import com.example.task.domain.subject.Subject;
import com.example.task.domain.subject.SubjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.example.task.api.subject.SubjectController.BASE_PATH_SUBJECT;


@RestController
@RequestMapping(BASE_PATH_SUBJECT)
public class SubjectController {


    private final SubjectServiceImpl subjectService;

    public SubjectController(SubjectServiceImpl subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<Subject> registerNewSubject(@RequestBody @Valid SubjectRegisterRequest request) {
        Subject newSubject = subjectService.registerNewSubject(request.name());
        return ResponseEntity.status(HttpStatus.CREATED).body(newSubject);
    }

    @GetMapping("/{subjectId}")
    ResponseEntity<SubjectDto> getSingleSubject(@PathVariable Long subjectId) {
        return ResponseEntity.of(subjectService.getSubject(subjectId).map(SubjectDto::fromDomain));
    }


    @PutMapping("/{subjectId}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long subjectId, @RequestBody SubjectRegisterRequest request) {
        Subject subject = new Subject(subjectId, request.name());
        Subject updateSubject = subjectService.updateSubject(subject);
        return ResponseEntity.created(URI.create("/subjects")).body(updateSubject);
    }

    static final String BASE_PATH_SUBJECT = "/subjects";

}
