package com.example.demo.Repository;

import com.example.demo.Model.Sprints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository <Sprints, Long> {




}
