package com.example.task.domain.classes;

import com.example.task.infrastructure.ClassesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassesServiceImpl implements ClassesService {
    private final ClassesRepository classesRepository;

    public ClassesServiceImpl(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;

    }

    @Override
    public Classes createNewClass(String name) {
        Classes newClasses = new Classes(name);
        return classesRepository.save(newClasses);
    }

    @Override
    public Optional<Classes> getClasses(Long classesId) {
        return classesRepository.findById(classesId);
    }

    @Override
    public Classes updateClasses(Classes classes) {
        return classesRepository.save(classes);
    }
}
