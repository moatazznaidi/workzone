package com.example.demo.Service;

import com.example.demo.Model.Tasks;
import com.example.demo.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository  ;

    public List<Tasks> getAllTasks(){
        List<Tasks> all =  tasksRepository.findAll();
        return all;}

    public Optional<Tasks> getTask(Long id){
        return  tasksRepository.findById(id);
    }

    public Tasks createTask (Tasks task){return  tasksRepository.save(task);}

    public  void deleteTask (Long id) { tasksRepository.deleteById(id);}

    public ResponseEntity<Tasks> updateTasks (Long id, Tasks task) {
        Optional<Tasks> TasksData = tasksRepository.findById(id);

        if (TasksData.isPresent()) {
            Tasks _task = TasksData.get();
            _task.setTaskName(task.getTaskName());
            _task.setDescription(task.getDescription());
            _task.setEstimatedTime(task.getEstimatedTime());
            _task.setProgress(task.getProgress());
            _task.setPriority(task.getPriority());
            _task.setTaskStartDate(task.getTaskStartDate());
            _task.setTasksEndDate(task.getTasksEndDate());
            _task.setAssignedTo(task.getAssignedTo());
            _task.setTaskType(task.getTaskType());
            _task.setName(task.getName());
            return new ResponseEntity<>(tasksRepository.save(_task), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}