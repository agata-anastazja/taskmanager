package com.example.taskmanager.persistence.repository.impl;

import com.example.taskmanager.persistence.model.Project;
import com.example.taskmanager.persistence.repository.IProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImpl implements IProjectRepository {

    List<Project> projects = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project exsistingProject = findById(project.getId()).orElse(null);
        if(exsistingProject == null) {
            projects.add(project);
        } else {
            projects.remove(exsistingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }
}
