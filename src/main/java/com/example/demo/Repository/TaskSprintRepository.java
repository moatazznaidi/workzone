package com.example.demo.Repository;

import com.example.demo.Model.VTasksprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSprintRepository extends JpaRepository<VTasksprint,Long> {
}
