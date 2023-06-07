package com.example.demo.Service;

import com.example.demo.Model.VTaskEmp;
import com.example.demo.Repository.TaskEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TaskEmployeeService {

    @Autowired
    private TaskEmployeeRepository taskemployeeRepository ;

    public VTaskEmp findTasksprintById(Long id) {

        //return null;
        return taskemployeeRepository.findById(id).orElse(null);
    }




    public List<VTaskEmp> findAllTasksprint(){
        List<VTaskEmp> all = taskemployeeRepository.findAll();
        return all;
    }
}
