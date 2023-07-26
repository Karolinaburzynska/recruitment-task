package com.example.task.api.lecturer;

import com.example.task.domain.lecturer.Lecturer;
import com.example.task.domain.lecturer.LecturerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.task.api.lecturer.LecturerController.BASE_PATH_LECTURER;

@RestController
@RequestMapping(BASE_PATH_LECTURER)
public class LecturerController {


    private final LecturerServiceImpl lecturerService;

    public LecturerController(LecturerServiceImpl lecturerService) {
        this.lecturerService = lecturerService;
    }


    @PostMapping
    public ResponseEntity<Lecturer> registerNewLecturer(@RequestBody @Valid LecturerRegisterRequest request) {
        Lecturer newLecturer = lecturerService.registerNewLecturer(request.name(), request.surname(), request.email(), request.subjectId());
        return ResponseEntity.status(HttpStatus.CREATED).body(newLecturer);
    }

    @GetMapping("/{lecturerId}")
    ResponseEntity<LecturerDto> getSingleLecturer(@PathVariable Long lecturerId) {
        return ResponseEntity.of(lecturerService.getLecturer(lecturerId).map(LecturerDto::fromDomain));
    }

    @DeleteMapping("/{deleteLecturerId}")
    public ResponseEntity<LecturerDto> deleteSingleLecturer(@PathVariable Long deleteLecturerId) {
        lecturerService.deleteLecturerById(deleteLecturerId);
        return ResponseEntity.noContent().build();
    }


    static final String BASE_PATH_LECTURER = "/lecturers";


}

