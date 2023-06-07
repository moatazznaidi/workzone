package com.example.demo.Service;

import com.example.demo.Model.VTasksprint;
import com.example.demo.Repository.TaskSprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskSprintService {
@Autowired
private TaskSprintRepository tasksprintRepository;



    public VTasksprint findTasksprintById(Long id) {

      //return null;
        return  tasksprintRepository.findById(id).orElse(null);
    }




    public List<VTasksprint> findAllTasksprint(){
        List<VTasksprint> all = tasksprintRepository.findAll();
        return all;
    }



}
