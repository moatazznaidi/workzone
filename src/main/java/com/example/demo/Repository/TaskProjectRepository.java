package com.example.demo.Repository;

import com.example.demo.Model.TasksProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskProjectRepository extends JpaRepository<TasksProject,Long> {


}
