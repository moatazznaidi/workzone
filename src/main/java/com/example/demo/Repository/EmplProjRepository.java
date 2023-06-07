package com.example.demo.Repository;

import com.example.demo.Model.EmplProj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmplProjRepository extends JpaRepository<EmplProj, Long> {
}
