package com.example.task.domain.classes;

import java.util.Optional;

public interface ClassesService {

    Classes createNewClass(String name);

    Optional<Classes> getClasses(Long classesId);

    Classes updateClasses(Classes classes);
}
