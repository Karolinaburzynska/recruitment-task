package com.example.task.api.classes;

import com.example.task.domain.classes.Classes;
import com.example.task.domain.classes.ClassesServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.example.task.api.classes.ClassesController.BASE_PATH_CLASSES;

@RestController
@RequestMapping(BASE_PATH_CLASSES)
public class ClassesController {


    private final ClassesServiceImpl classesService;

    public ClassesController(ClassesServiceImpl classesService) {
        this.classesService = classesService;
    }

    @PostMapping
    public ResponseEntity<Classes> createNewClass(@RequestBody @Valid ClassesRegisterRequest request) {
        Classes newClasses = classesService.createNewClass(request.name());
        return ResponseEntity.status(HttpStatus.CREATED).body(newClasses);
    }


    @GetMapping("/{classesId}")
    ResponseEntity<ClassesDto> getSingleClasses(@PathVariable Long classesId) {
        return ResponseEntity.of(classesService.getClasses(classesId).map(ClassesDto::fromDomain));
    }


    @PutMapping("/{classesId}")
    public ResponseEntity<Classes> updateClasses(@PathVariable Long classesId, @RequestBody ClassesRegisterRequest request) {
        Classes classes = new Classes(classesId, request.name());
        Classes updateClasses = classesService.updateClasses(classes);
        return ResponseEntity.created(URI.create("/classes")).body(updateClasses);
    }

    static final String BASE_PATH_CLASSES = "/classes";


}
