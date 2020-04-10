package com.example.taskmanager.persistence.repository;

import com.example.taskmanager.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
