package com.example.demo.Service;

import com.example.demo.Model.Project;
import com.example.demo.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProject() {
        List<Project> all = projectRepository.findAll();
        return all;
    }

    public Optional<Project> getProject(Long id) {
        return projectRepository.findById(id);
    }

    public Project createProj(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProj(Long id) {
        projectRepository.deleteById(id);
    }


    public ResponseEntity<Project> updateProj(Long id, Project project) {
        Optional<Project> ProjectData = projectRepository.findById(id);

        if (ProjectData.isPresent()) {
            Project _project = ProjectData.get();
            _project.setName(project.getName());
            _project.setDescription(project.getDescription());
            _project.setIsPublic(project.getIsPublic());
            _project.setStartDate(project.getStartDate());
            _project.setEndDate(project.getEndDate());
            _project.setWorkStatus(project.getWorkStatus());
            _project.setTeam(project.getTeam());
            _project.setProgress(project.getProgress());
            _project.setClient(project.getClient());
            _project.setPriority(project.getPriority());
            _project.setPrice(project.getPrice());

            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public Long countProjects() {
        return projectRepository.count();
    }
}
