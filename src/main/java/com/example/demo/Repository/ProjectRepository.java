package com.example.demo.Repository;

import com.example.demo.Model.Employees;
import com.example.demo.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long>  {

}
