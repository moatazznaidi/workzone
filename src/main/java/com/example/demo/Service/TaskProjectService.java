package com.example.demo.Service;

import com.example.demo.Model.TasksProject;
import com.example.demo.Repository.TaskProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskProjectService {

    @Autowired
    private TaskProjectRepository taskProjectRepository ;

    public List<TasksProject> getAllTaskProject(){
        List<TasksProject> all =  taskProjectRepository.findAll();
        return all;}
    public Optional<TasksProject> getTaskProj(Long id){
        return  taskProjectRepository.findById(id);
    }

    public TasksProject createTaskProj (TasksProject tasksProject){return  taskProjectRepository.save(tasksProject);}

    public  void deleteTaskProj(Long id) { taskProjectRepository.deleteById(id);}

    public ResponseEntity<TasksProject> UpdateTasksProj(Long id, TasksProject tasksProject) {
        Optional<TasksProject> TasksProjectData = taskProjectRepository.findById(id);

        if (TasksProjectData.isPresent()) {
            TasksProject _taskProject = TasksProjectData.get();
            _taskProject.setTaskNameProject(tasksProject.getTaskNameProject());
            _taskProject.setDescription(tasksProject.getDescription());
            _taskProject.setEstimatedTime(tasksProject.getEstimatedTime());
            _taskProject.setProgress(tasksProject.getProgress());
            _taskProject.setPriority(tasksProject.getPriority());
            _taskProject.setTaskStartDate(tasksProject.getTaskStartDate());
            _taskProject.setTasksEndDate(tasksProject.getTasksEndDate());
            _taskProject.setAssignedTo(tasksProject.getAssignedTo());
            _taskProject.setTaskProjectType(tasksProject.getTaskProjectType());
            _taskProject.setName(tasksProject.getName());


            return new ResponseEntity<>(taskProjectRepository.save(_taskProject), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
