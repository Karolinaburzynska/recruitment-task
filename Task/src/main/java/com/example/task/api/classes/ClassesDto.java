package com.example.task.api.classes;

import com.example.task.domain.classes.Classes;

public record ClassesDto(Long id, String name) {

    public static ClassesDto fromDomain(Classes classes) {
        return new ClassesDto(
                classes.getId(),
                classes.getName()
        );
    }
}
